package com.ngantcb.trekking.services.admin.trip;

import com.ngantcb.trekking.dto.TripDto;

import java.io.IOException;
import java.util.List;

public interface TripService {
    TripDto createTrip(TripDto tripDto) throws IOException;
    List<TripDto> getAllTrips();
}
