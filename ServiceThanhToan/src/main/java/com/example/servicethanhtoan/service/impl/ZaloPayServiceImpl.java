package com.example.servicethanhtoan.service.impl;


import com.example.servicethanhtoan.dto.request.PaymentOneWay;
import com.example.servicethanhtoan.dto.request.PaymentTwoWay;
import com.example.servicethanhtoan.entity.Ticket;
import com.example.servicethanhtoan.mapper.TicketMapper;
import com.example.servicethanhtoan.repository.TicketRepository;
import com.example.servicethanhtoan.service.ZaloPayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ZaloPayServiceImpl implements ZaloPayService {
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;


    @Override
    @Transactional()
    public boolean createOrderOneWayTrip(PaymentOneWay paymentOneWay) {
        List<Ticket> tickets = ticketMapper.oneWayTicketToTicket(paymentOneWay);
        ticketRepository.saveAll(tickets);
        return true;
    }

    @Override
    @Transactional
    public boolean createOrderRoundTrip(PaymentTwoWay paymentTwoWay) {
        List<Ticket> tickets = ticketMapper.twoWayTicketToTicket(paymentTwoWay);
        ticketRepository.saveAll(tickets);
        return true;
    }
}
