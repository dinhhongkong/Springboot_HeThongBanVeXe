package com.example.servicequanly.service;

import com.example.servicequanly.dto.request.BusCreationRequest;
import com.example.servicequanly.dto.request.BusUpdateRequest;
import com.example.servicequanly.entity.Bus;

import java.util.List;

public interface BusService {
    List<Bus> getListBus();
    Bus insertBus(BusCreationRequest busCreationRequest);

    Bus updateBus(BusUpdateRequest busUpdateRequest);

    Bus deleteBus(int id);
}
