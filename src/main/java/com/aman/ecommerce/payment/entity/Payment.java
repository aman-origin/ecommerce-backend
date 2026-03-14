package com.aman.ecommerce.payment.entity;

import com.aman.ecommerce.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private BigDecimal amount;

    private String paymentMethod;

    private String status;

    private LocalDateTime createdAt;

}
