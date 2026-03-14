package com.aman.ecommerce.payment.service;

import com.aman.ecommerce.payment.dto.CreatePaymentRequest;

public interface PaymentService {

    void makePayment(CreatePaymentRequest request);

}
