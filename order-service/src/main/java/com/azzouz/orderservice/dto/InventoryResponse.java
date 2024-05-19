package com.azzouz.orderservice.dto;/*
 * @created 15/01/2023 - 14:46
 * @project inventory-service
 * @author Azzouz
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
