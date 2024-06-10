package com.example.servicequanly.controller;

import com.example.servicequanly.dto.request.JourneyCreationRequest;
import com.example.servicequanly.dto.response.JourneyResponse;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.JourneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class JourneyController {

    private final JourneyService journeyService;


    @GetMapping("/journeys")
    public ResponseEntity<?> getListJourney(@RequestParam(required = false) LocalDate startDate) {
        RespondData respondData = new RespondData();
        List<JourneyResponse> journeyResponseList;
        if (startDate != null) {
            journeyResponseList = journeyService.getListJourneyByDate(startDate);
        } else {
            journeyResponseList = journeyService.getListJourney();
        }

        if (!journeyResponseList.isEmpty()) {
            respondData.setStatus(200);
            respondData.setData(journeyResponseList);
            respondData.setMessage("Lay Danh Sach Thanh Cong");
        } else {
            respondData.setStatus(200);
            respondData.setData(null);
            respondData.setMessage("Khong co du lieu");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }


    @PostMapping("/journey")
    public ResponseEntity<?> addJourney(@RequestBody JourneyCreationRequest journeyCreationRequest) {
        RespondData respondData = new RespondData();
        JourneyResponse journeyResponse = journeyService.addJourney(journeyCreationRequest);
        respondData.setStatus(200);
        respondData.setData(journeyResponse);
        respondData.setMessage("Lưu thành công");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @DeleteMapping("/journey")
    public ResponseEntity<?> deleteJourney(@RequestParam("id") int id) {
        JourneyResponse journeyResponse = journeyService.deleteJourney(id);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(journeyResponse);
        respondData.setMessage("Xóa thành công");
        return new ResponseEntity<>(respondData, HttpStatus.ACCEPTED);
    }


}
