package com.ngantcb.trekking.services.destination;

import com.ngantcb.trekking.dto.DestinationDto;
import com.ngantcb.trekking.entity.Destination;
import com.ngantcb.trekking.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;

    @Override
    public Destination createDestination(DestinationDto destinationDto){
        Destination destination = new Destination();
        destination.setCity(destinationDto.getCity());

        return destinationRepository.save(destination);
    }
    @Override
    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }

}
