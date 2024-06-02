package com.example.servicethanhtoan.repository;

import com.example.servicethanhtoan.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    Ticket save(Ticket ticket);
    Ticket findById(int id);


}
