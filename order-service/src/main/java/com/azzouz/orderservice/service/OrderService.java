package com.azzouz.orderservice.service;/*
 * @created 08/01/2023 - 22:45
 * @project order-service
 * @author Azzouz
 */

import com.azzouz.orderservice.dto.InventoryResponse;
import com.azzouz.orderservice.config.WebClientConfig;
import com.azzouz.orderservice.dto.OrderLineItemsDto;
import com.azzouz.orderservice.dto.OrderRequest;
import com.azzouz.orderservice.event.OrderPlacedEvent;
import com.azzouz.orderservice.model.Order;
import com.azzouz.orderservice.model.OrderLineItems;
import com.azzouz.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClientConfig webClientBuilder;
   private final Tracer tracer;
   private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);


        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
         log.info("Calling inventory service");

        Span inventoryServiceLookup =tracer.nextSpan().name("InventoryServiceLookup");

        try (Tracer.SpanInScope isLookup = tracer.withSpan(inventoryServiceLookup.start())) {
        // call Inventory service, and place order if the product is in stock

        InventoryResponse[] inventoryResponsesArray = webClientBuilder.webClientBuilder().build().get()
                        .uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                        .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                        .block();

            boolean allProductsInStock = false;
            if (inventoryResponsesArray != null) {
                allProductsInStock = Arrays.stream(inventoryResponsesArray)
                        .allMatch(InventoryResponse::isInStock);
            }

            if(allProductsInStock){
            orderRepository.save(order);
            kafkaTemplate.send("notificationTopic",new OrderPlacedEvent((order.getOrderNumber())));
            return "Order Placed Successfully :D";
           } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
          }
        }finally {
            inventoryServiceLookup.end();

        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
