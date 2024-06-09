package com.example.servicequanly.mapper;

import com.example.servicequanly.dto.request.BusCreationRequest;
import com.example.servicequanly.dto.request.BusUpdateRequest;
import com.example.servicequanly.entity.Bus;

public interface BusMapper {
    Bus busCreationRequestToBus(BusCreationRequest busCreationRequest);

    Bus busUpdateRequestToBus(BusUpdateRequest busUpdateRequest);
}
