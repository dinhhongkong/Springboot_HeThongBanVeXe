package com.example.servicequanly.controller;

import com.example.servicequanly.dto.request.BusCreationRequest;
import com.example.servicequanly.dto.request.BusUpdateRequest;
import com.example.servicequanly.entity.Bus;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping("/buses")
    public ResponseEntity<?> getListBus() {
        RespondData respondData = new RespondData();
        List<Bus> busList = busService.getListBus();
        if (!busList.isEmpty()) {
            respondData.setStatus(200);
            respondData.setData(busList);
            respondData.setMessage("Lay Danh Sach Thanh Cong");
        } else {
            respondData.setStatus(200);
            respondData.setData(null);
            respondData.setMessage("Khong co du lieu");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/bus")
    public ResponseEntity<?> insertBus(@RequestBody BusCreationRequest busCreationRequest) {
        Bus bus = busService.insertBus(busCreationRequest);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.CREATED.value());
        respondData.setData(bus);
        respondData.setMessage("Them Xe Thanh Cong");
        return new ResponseEntity<>(respondData, HttpStatus.CREATED);
    }

    @PutMapping("/bus")
    public ResponseEntity<?> updateBus(@RequestBody BusUpdateRequest busUpdateRequest) {
        Bus bus = busService.updateBus(busUpdateRequest);
        RespondData respondData = new RespondData();
        respondData.setStatus(200);
        respondData.setData(bus);
        respondData.setMessage("Sua Thong Tin Xe Thanh Cong");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @DeleteMapping("/bus")
    public ResponseEntity<?> deleteBus(@RequestParam int id) {
        Bus bus = busService.deleteBus(id);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(bus);
        respondData.setMessage("Xóa xe thành công");
        return new ResponseEntity<>(respondData, HttpStatus.ACCEPTED);
    }
}
