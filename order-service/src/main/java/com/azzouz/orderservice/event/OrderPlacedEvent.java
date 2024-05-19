package com.azzouz.orderservice.event;/*
 * @created 20/01/2023 - 13:21
 * @project micoservices-parent
 * @author Azzouz
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String orderNumber;
}
