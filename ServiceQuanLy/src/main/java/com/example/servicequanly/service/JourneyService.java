package com.example.servicequanly.service;

import com.example.servicequanly.dto.request.JourneyCreationRequest;
import com.example.servicequanly.dto.response.JourneyResponse;

import java.time.LocalDate;
import java.util.List;

public interface JourneyService {

    List<JourneyResponse> getListJourney();
    List<JourneyResponse> getListJourneyByDate(LocalDate localDate);
    JourneyResponse addJourney(JourneyCreationRequest journeyCreationRequest);
    JourneyResponse deleteJourney(int journeyId);
}
