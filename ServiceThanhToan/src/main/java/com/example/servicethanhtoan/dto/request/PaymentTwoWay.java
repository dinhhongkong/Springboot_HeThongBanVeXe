package com.example.servicethanhtoan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentTwoWay {
    private int paymentStatus;
    private List<String> seatDepartureName;
    private List<String> seatReturnName;
    private int customerId;
    private int journeyDepartureTrip;
    private int journeyReturnTrip;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String transactionId;
}
