package com.example.servicethanhtoan.service;

import com.example.servicethanhtoan.dto.request.PaymentOneWay;
import com.example.servicethanhtoan.dto.request.PaymentTwoWay;

public interface ZaloPayService {
    boolean createOrderOneWayTrip(PaymentOneWay paymentOneWay);
    boolean createOrderRoundTrip(PaymentTwoWay paymentTwoWay);

}
