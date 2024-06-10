package com.example.servicequanly.mapper.imp;

import com.example.servicequanly.dto.request.BusCreationRequest;
import com.example.servicequanly.dto.request.BusUpdateRequest;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.mapper.BusMapper;
import org.springframework.stereotype.Component;

@Component
public class BusMapperImp implements BusMapper {

    @Override
    public Bus busCreationRequestToBus(BusCreationRequest busCreationRequest) {
        return Bus.builder()
                .licensePlate(busCreationRequest.getLicensePlate())
                .busType(busCreationRequest.getBusType())
                .build();
    }

    @Override
    public Bus busUpdateRequestToBus(BusUpdateRequest busUpdateRequest) {
        return Bus.builder()
                .id(busUpdateRequest.getId())
                .licensePlate(busUpdateRequest.getLicensePlate())
                .busType(busUpdateRequest.getBusType())
                .build();
    }

}
