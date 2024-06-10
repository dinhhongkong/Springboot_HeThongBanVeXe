package com.example.servicequanly.service.imp;

import com.example.servicequanly.dto.request.JourneyCreationRequest;
import com.example.servicequanly.dto.response.JourneyResponse;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.entity.Journey;
import com.example.servicequanly.entity.JourneyDetail;
import com.example.servicequanly.mapper.JourneyMapper;
import com.example.servicequanly.repository.JourneyDetailRepository;
import com.example.servicequanly.repository.JourneyRepository;
import com.example.servicequanly.service.JourneyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class JourneyServiceImp implements JourneyService {
    private final JourneyRepository journeyRepository;
    private final JourneyDetailRepository journeyDetailRepository;
    private final JourneyMapper journeyMapper;
    @Override
    public List<JourneyResponse> getListJourney() {
        List<Journey> journeyList  = journeyRepository.findAll();
        return journeyMapper.journeyToJourneyResponse(journeyList);
    }

    @Override
    public List<JourneyResponse> getListJourneyByDate(LocalDate localDate) {
        List<Journey> journeyList  = journeyRepository.findAllByDepartureDateGreaterThanEqual(localDate);
        return journeyMapper.journeyToJourneyResponse(journeyList);
    }

    @Override
    @Transactional
    public JourneyResponse addJourney(JourneyCreationRequest journeyCreationRequest) {
        Journey journey = journeyMapper.journeyCreationRequestToJourney(journeyCreationRequest);
        Journey journey1 = journeyRepository.save(journey);

        for(Integer driverId:  journeyCreationRequest.getDrivers()) {
            journeyDetailRepository.save(
                    JourneyDetail.builder()
                            .driverId(driverId)
                            .journeyId(journey.getId())
                            .build());
        }
        return journeyMapper.journeyToJourneyResponse(journey);
    }

    @Override
    @Transactional
    public JourneyResponse deleteJourney(int journeyId) {
        Journey journey = journeyRepository
                .findById(journeyId)
                .orElseThrow(() -> new EntityNotFoundException("Journey not found with id " + journeyId));
        journeyRepository.deleteById(journeyId);
        return journeyMapper.journeyToJourneyResponse(journey);
    }
}
