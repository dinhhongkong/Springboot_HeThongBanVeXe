package com.example.servicethanhtoan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTwoWay {
    private int paymentStatus;
    private Set<String> seatDepartureName;
    private Set<String> seatReturnName;
    private int customerId;
    private int journeyDepartureTrip;
    private int journeyReturnTrip;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String transactionId;
}
