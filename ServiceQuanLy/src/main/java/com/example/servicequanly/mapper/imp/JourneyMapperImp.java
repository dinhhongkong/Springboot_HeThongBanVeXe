package com.example.servicequanly.mapper.imp;

import com.example.servicequanly.dto.request.JourneyCreationRequest;
import com.example.servicequanly.dto.response.JourneyResponse;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.entity.Journey;
import com.example.servicequanly.entity.Province;
import com.example.servicequanly.mapper.JourneyMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JourneyMapperImp implements JourneyMapper {
    @Override
    public JourneyResponse journeyToJourneyResponse(Journey journey) {
        return JourneyResponse.builder()
                .id(journey.getId())
                .departureDate(journey.getDepartureDate())
                .departureTime(journey.getDepartureTime())
                .estimatedTime(journey.getEstimatedTime())
                .price(journey.getPrice())
                .bus(journey.getBus())
                .departureProvince(journey.getStartProvince().getProvinceName())
                .destProvince(journey.getDestProvince().getProvinceName())
                .build();
    }

    @Override
    public List<JourneyResponse> journeyToJourneyResponse(List<Journey> journeyList) {
        List<JourneyResponse> journeyResponseList = new ArrayList<>();
        for (Journey journey: journeyList){
            JourneyResponse journeyResponse = journeyToJourneyResponse(journey);
            journeyResponseList.add(journeyResponse);
        }
        return journeyResponseList;
    }

    @Override
    public Journey journeyCreationRequestToJourney(JourneyCreationRequest journeyCreationRequest) {
        return Journey.builder()
                .departureDate(journeyCreationRequest.getDepartureDate())
                .departureTime(journeyCreationRequest.getDepartureTime())
                .estimatedTime(journeyCreationRequest.getEstimatedTime())
                .price(journeyCreationRequest.getPrice())
                .employee(Employee.builder()
                        .id(journeyCreationRequest.getEmployeeId())
                        .build())
                .bus(Bus.builder()
                        .id(journeyCreationRequest.getBusId())
                        .build())
                .startProvince(Province.builder()
                        .provinceId(journeyCreationRequest.getDepartureProvinceId())
                        .build())
                .destProvince(Province.builder()
                        .provinceId(journeyCreationRequest.getDestProvinceId())
                        .build())
                .build();
    }
}
