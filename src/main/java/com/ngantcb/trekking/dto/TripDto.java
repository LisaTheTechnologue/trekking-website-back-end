package com.ngantcb.trekking.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TripDto {
    private Long id;
    private String highlights;

    private byte[] imgByte;
    private Long destinationId;

    private MultipartFile img;
}
