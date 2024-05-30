package com.example.servicethanhtoan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private int paymentStatus;
    private String orderInfo;
    private String totalPrice;
    private String paymentTime;
    private String transactionId;

}
