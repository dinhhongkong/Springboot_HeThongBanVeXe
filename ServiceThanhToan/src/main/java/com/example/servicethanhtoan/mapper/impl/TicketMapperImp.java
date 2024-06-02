package com.example.servicethanhtoan.mapper.impl;

import com.example.servicethanhtoan.dto.request.PaymentOneWay;
import com.example.servicethanhtoan.dto.request.PaymentTwoWay;
import com.example.servicethanhtoan.entity.ChuyenXe;
import com.example.servicethanhtoan.entity.Ticket;
import com.example.servicethanhtoan.mapper.TicketMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapperImp implements TicketMapper {
    @Override
    public List<Ticket> oneWayTicketToTicket(PaymentOneWay ticketOneWay) {

        return ticketOneWay.getSeatName().stream().map(seat -> {
            Ticket ticket = new Ticket();
            ticket.setDateOrder(LocalDateTime.now().toString());
            ticket.setPaymentStatus(ticketOneWay.getPaymentStatus());
            ticket.setSeatName(seat);
            ticket.setFullName(ticketOneWay.getFullName());
            ticket.setPhoneNumber(ticketOneWay.getPhoneNumber());
            ticket.setEmail(ticketOneWay.getEmail());
            ticket.setTransactionId(ticketOneWay.getTransactionId());
            ticket.setPaymentMethod("ZaloPay");
            ticket.setChuyenXe( ChuyenXe.builder().id(ticketOneWay.getJourneyTrip()).build());
            return ticket;
        }).collect(Collectors.toList());

    }

    @Override
    public List<Ticket> twoWayTicketToTicket(PaymentTwoWay ticketTwoWay) {
        List<Ticket> tickets = new ArrayList<>();

        // Duyệt qua danh sách ghế của chuyến đi
        for (String seat : ticketTwoWay.getSeatDepartureName()) {
            Ticket ticket = new Ticket();
            ticket.setDateOrder(LocalDateTime.now().toString());
            ticket.setPaymentStatus(ticketTwoWay.getPaymentStatus());
            ticket.setSeatName(seat);
            ticket.setFullName(ticketTwoWay.getFullName());
            ticket.setPhoneNumber(ticketTwoWay.getPhoneNumber());
            ticket.setEmail(ticketTwoWay.getEmail());
            ticket.setTransactionId(ticketTwoWay.getTransactionId());
            ticket.setPaymentMethod("ZaloPay");
            // Set the ChuyenXe object here
             ticket.setChuyenXe(ChuyenXe.builder().id(ticketTwoWay.getJourneyDepartureTrip()).build());
            tickets.add(ticket);
        }

        // Duyệt qua danh sách ghế của chuyến về
        for (String seat : ticketTwoWay.getSeatReturnName()) {
            Ticket ticket = new Ticket();
            ticket.setDateOrder(LocalDateTime.now().toString());
            ticket.setPaymentStatus(ticketTwoWay.getPaymentStatus());
            ticket.setSeatName(seat);
            ticket.setFullName(ticketTwoWay.getFullName());
            ticket.setPhoneNumber(ticketTwoWay.getPhoneNumber());
            ticket.setEmail(ticketTwoWay.getEmail());
            ticket.setTransactionId(ticketTwoWay.getTransactionId());
            ticket.setPaymentMethod("ZaloPay");
            ticket.setChuyenXe(ChuyenXe.builder().id(ticketTwoWay.getJourneyReturnTrip()).build());
            tickets.add(ticket);
        }

        return tickets;
    }
}
