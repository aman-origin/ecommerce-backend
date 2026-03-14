package com.aman.ecommerce.payment.dto;

import lombok.Data;

@Data
public class CreatePaymentRequest {

    private Long orderId;
    private String paymentMethod;

}
