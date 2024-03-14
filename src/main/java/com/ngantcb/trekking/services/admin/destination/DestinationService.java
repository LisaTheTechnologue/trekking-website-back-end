package com.ngantcb.trekking.services.admin.destination;

import com.ngantcb.trekking.dto.DestinationDto;
import com.ngantcb.trekking.entity.Destination;

import java.util.List;

public interface DestinationService {
    Destination createDestination(DestinationDto destinationDto);
    List<Destination> getAllDestinations();
}
