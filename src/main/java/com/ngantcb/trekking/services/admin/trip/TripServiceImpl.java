package com.ngantcb.trekking.services.admin.trip;

import com.ngantcb.trekking.dto.TripDto;
import com.ngantcb.trekking.entity.Destination;
import com.ngantcb.trekking.entity.Trip;
import com.ngantcb.trekking.repository.DestinationRepository;
import com.ngantcb.trekking.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;


    @Override
    public TripDto createTrip(TripDto tripDto) throws IOException {
        Trip trip = new Trip();
        trip.setHighlights(tripDto.getHighlights());
        trip.setImgBlob(tripDto.getImg().getBytes());

        Destination destination = destinationRepository.findById(tripDto.getDestinationId()).orElseThrow();

        trip.setDestination(destination);
        return tripRepository.save(trip).getDto();
    }

    @Override
    public List<TripDto> getAllTrips(){
        List<Trip> trips = tripRepository.findAll();
        return trips.stream().map(Trip::getDto).collect(Collectors.toList());
    }
}
