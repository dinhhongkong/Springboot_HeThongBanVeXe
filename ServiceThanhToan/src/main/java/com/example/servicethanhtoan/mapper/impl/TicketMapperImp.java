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
            Ticket ticket = Ticket.builder()
                    .dateOrder(LocalDateTime.now().toString())
                    .paymentStatus(ticketOneWay.getPaymentStatus())
                    .seatName(seat)
                    .fullName(ticketOneWay.getFullName())
                    .phoneNumber(ticketOneWay.getPhoneNumber())
                    .email(ticketOneWay.getEmail())
                    .transactionId(ticketOneWay.getTransactionId())
                    .paymentMethod("ZaloPay")
                    .chuyenXe(ChuyenXe.builder().id(ticketOneWay.getJourneyTrip()).build())
                    .build();

            return ticket;
        }).collect(Collectors.toList());

    }

    @Override
    public List<Ticket> twoWayTicketToTicket(PaymentTwoWay ticketTwoWay) {
        List<Ticket> tickets = new ArrayList<>();

        // Duyệt qua danh sách ghế của chuyến đi
        for (String seat : ticketTwoWay.getSeatDepartureName()) {
            Ticket ticket = Ticket.builder()
                    .dateOrder(LocalDateTime.now().toString())
                    .paymentStatus(ticketTwoWay.getPaymentStatus())
                    .seatName(seat)
                    .fullName(ticketTwoWay.getFullName())
                    .phoneNumber(ticketTwoWay.getPhoneNumber())
                    .email(ticketTwoWay.getEmail())
                    .transactionId(ticketTwoWay.getTransactionId())
                    .paymentMethod("ZaloPay")
                    .build();
            // Set the ChuyenXe object here
            ticket.setChuyenXe(ChuyenXe.builder().id(ticketTwoWay.getJourneyDepartureTrip()).build());
            tickets.add(ticket);
        }

        // Duyệt qua danh sách ghế của chuyến về
        for (String seat : ticketTwoWay.getSeatReturnName()) {
            Ticket ticket = Ticket.builder()
                    .dateOrder(LocalDateTime.now().toString())
                    .paymentStatus(ticketTwoWay.getPaymentStatus())
                    .seatName(seat)
                    .fullName(ticketTwoWay.getFullName())
                    .phoneNumber(ticketTwoWay.getPhoneNumber())
                    .email(ticketTwoWay.getEmail())
                    .transactionId(ticketTwoWay.getTransactionId())
                    .paymentMethod("ZaloPay")
                    .chuyenXe(ChuyenXe.builder().id(ticketTwoWay.getJourneyReturnTrip()).build())
                    .build();
            tickets.add(ticket);
        }

        return tickets;
    }
}
