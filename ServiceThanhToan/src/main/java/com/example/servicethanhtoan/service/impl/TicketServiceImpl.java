package com.example.servicethanhtoan.service.impl;

import com.example.servicethanhtoan.entity.Ticket;
import com.example.servicethanhtoan.repository.TicketRepository;
import com.example.servicethanhtoan.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket findById(int id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
