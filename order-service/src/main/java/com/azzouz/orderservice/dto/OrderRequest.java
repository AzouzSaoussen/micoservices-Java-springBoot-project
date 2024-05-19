package com.azzouz.orderservice.dto;/*
 * @created 08/01/2023 - 22:47
 * @project order-service
 * @author Azzouz
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
