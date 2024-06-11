package com.example.servicethanhtoan.service.impl;


import com.example.servicethanhtoan.dto.request.PaymentOneWay;
import com.example.servicethanhtoan.dto.request.PaymentTwoWay;
import com.example.servicethanhtoan.entity.ChuyenXe;
import com.example.servicethanhtoan.entity.Ticket;
import com.example.servicethanhtoan.mapper.TicketMapper;
import com.example.servicethanhtoan.repository.ChuyenXeRepository;
import com.example.servicethanhtoan.repository.TicketRepository;
import com.example.servicethanhtoan.service.SmsService;
import com.example.servicethanhtoan.service.ZaloPayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ZaloPayServiceImpl implements ZaloPayService {
    private TicketRepository ticketRepository;
    private ChuyenXeRepository chuyenXeRepository;
    private TicketMapper ticketMapper;
    private SmsService smsService;


    @Override
    @Transactional
    public boolean createOrderOneWayTrip(PaymentOneWay paymentOneWay) {
        List<Ticket> tickets = ticketMapper.oneWayTicketToTicket(paymentOneWay);
        Optional<ChuyenXe> chuyenXe = chuyenXeRepository.findById(paymentOneWay.getJourneyTrip());
        List<Ticket> ticketList= ticketRepository.saveAll(tickets);
        System.out.println("ve da them la: "+  ticketList);
        ArrayList<Integer> ticketIdList = new ArrayList<>();
        for (Ticket ticket: ticketList) {
            ticketIdList.add(ticket.getId());
        }
        smsService.sendSms(
                paymentOneWay.getPhoneNumber(),
                ticketIdList,
                chuyenXe.get().getNgayKhoiHanh(),
                chuyenXe.get().getGioXuatPhat());
        return true;
    }

    @Override
    @Transactional
    public boolean createOrderRoundTrip(PaymentTwoWay paymentTwoWay) {
        List<Ticket> tickets = ticketMapper.twoWayTicketToTicket(paymentTwoWay);
        List<Ticket> ticketList = ticketRepository.saveAll(tickets);
        return true;
    }
}
