package com.example.servicethanhtoan.service;

import com.example.servicethanhtoan.entity.Ticket;

public interface TicketService {
    Ticket findById(int id);
    Ticket save(Ticket ticket);
}
