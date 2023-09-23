package com.mediaocean.hotel.userstory.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HotelReviewDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int hotelid;
    private String rating;
    private String summary;
    private String details;
    private Date checkin;
    private String name;




    public HotelReviewDto(){
        super();
    }

}
