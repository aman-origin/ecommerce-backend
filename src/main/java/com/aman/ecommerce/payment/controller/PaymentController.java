package com.aman.ecommerce.payment.controller;

import com.aman.ecommerce.payment.dto.CreatePaymentRequest;
import com.aman.ecommerce.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public void makePayment(@RequestBody CreatePaymentRequest request) {
        paymentService.makePayment(request);
    }

}
