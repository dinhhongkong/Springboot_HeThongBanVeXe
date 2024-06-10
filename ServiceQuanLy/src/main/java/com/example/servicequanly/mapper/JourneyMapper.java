package com.example.servicequanly.mapper;

import com.example.servicequanly.dto.request.JourneyCreationRequest;
import com.example.servicequanly.dto.response.JourneyResponse;
import com.example.servicequanly.entity.Journey;

import java.util.List;

public interface JourneyMapper {
    JourneyResponse journeyToJourneyResponse(Journey journey);
    List<JourneyResponse> journeyToJourneyResponse(List<Journey> journeyList);

    Journey journeyCreationRequestToJourney(JourneyCreationRequest journeyCreationRequest);
}
