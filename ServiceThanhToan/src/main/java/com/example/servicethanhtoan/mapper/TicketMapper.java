package com.example.servicethanhtoan.mapper;

import com.example.servicethanhtoan.dto.request.PaymentOneWay;
import com.example.servicethanhtoan.dto.request.PaymentTwoWay;
import com.example.servicethanhtoan.entity.Ticket;

import java.util.List;

public interface TicketMapper {

    List<Ticket> oneWayTicketToTicket(PaymentOneWay ticketOneWay);
    List<Ticket> twoWayTicketToTicket(PaymentTwoWay ticketTwoWay);

}
