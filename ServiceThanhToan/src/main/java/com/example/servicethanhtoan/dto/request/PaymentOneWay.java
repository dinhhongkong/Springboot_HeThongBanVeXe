package com.example.servicethanhtoan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOneWay {
    private int paymentStatus;
    private Set<String> seatName;
    private int customerId;
    private int journeyTrip;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String transactionId;
}
