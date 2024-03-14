package com.ngantcb.trekking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ngantcb.trekking.dto.TripDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Table(name = "t_trip", schema = "trekking_owner")
@Entity
@Data
public class Trip {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "highlights")
    private String highlights;

    @Lob
    @Column(name = "img_blob")
    private byte[] imgBlob;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Destination destination;

    @Column(name = "is_active")
    private Boolean isActive;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public TripDto getDto(){
        TripDto tripDto = new TripDto();
        tripDto.setId(id);
        tripDto.setHighlights(highlights);
        tripDto.setImgByte(imgBlob);
        tripDto.setDestinationId(destination.getId());
        return tripDto;
    }
}
