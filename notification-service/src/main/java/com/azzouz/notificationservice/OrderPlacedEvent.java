package com.azzouz.notificationservice;/*
 * @created 21/01/2023 - 20:27
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
