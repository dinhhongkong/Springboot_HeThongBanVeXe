package com.example.servicequanly.service.imp;


import com.example.servicequanly.dto.request.BusCreationRequest;
import com.example.servicequanly.dto.request.BusUpdateRequest;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.mapper.BusMapper;
import com.example.servicequanly.repository.BusRepository;
import com.example.servicequanly.service.BusService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusServiceImp implements BusService {

    private BusRepository busRepository;
    private BusMapper busMapper;


    @Override
    public List<Bus> getListBus() {
        return busRepository.findAll();
    }

    @Override
    public Bus insertBus(BusCreationRequest busCreationRequest) {
        Bus bus = busMapper.busCreationRequestToBus(busCreationRequest);
        if (busCreationRequest.getBusType().equals("Limousine")) {
            bus.setTotalSeats(36);
        }
        else if (busCreationRequest.getBusType().equals("Giường nằm")) {
            bus.setTotalSeats(44);
        }
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(BusUpdateRequest busCreationRequest) {
        Bus bus = busMapper.busUpdateRequestToBus(busCreationRequest);
        if (busCreationRequest.getBusType().equals("Limousine")) {
            bus.setTotalSeats(36);
        }
        else if (busCreationRequest.getBusType().equals("Giường nằm")) {
            bus.setTotalSeats(44);
        }
        return busRepository.save(bus);
    }

    @Override
    @Transactional
    public Bus deleteBus(int id) {
        Bus bus = busRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus not found with id " + id));
        busRepository.deleteById(id);
        return bus;
    }


}
