package com.azzouz.orderservice.repository;/*
 * @created 08/01/2023 - 22:45
 * @project order-service
 * @author Azzouz
 */


import com.azzouz.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long>{
}
