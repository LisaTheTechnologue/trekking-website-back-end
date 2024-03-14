package com.ngantcb.trekking.controller;

import com.ngantcb.trekking.dto.TripDto;
import com.ngantcb.trekking.services.trip.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @PostMapping("/create")
    public ResponseEntity<TripDto> createTrip (@ModelAttribute TripDto tripDto) throws IOException {
        TripDto tripDto1 = tripService.createTrip(tripDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripDto1);
    }
    @GetMapping("")
    public ResponseEntity<List<TripDto>> getAllTrips (){
        List<TripDto> tripDtos = tripService.getAllTrips();
        return ResponseEntity.ok(tripDtos);
    }
}
