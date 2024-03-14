package com.ngantcb.trekking.controller;

import com.ngantcb.trekking.dto.DestinationDto;
import com.ngantcb.trekking.entity.Destination;
import com.ngantcb.trekking.services.destination.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminDestinationController {

    private final DestinationService destinationService;

    @PostMapping("destination")
    public ResponseEntity<Destination> createDestination (@RequestBody DestinationDto destinationDto){
        Destination destination = destinationService.createDestination(destinationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(destination);
    }
    @GetMapping("destinations")
    public ResponseEntity<List<Destination>> getAllDestinations (){
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }
}
