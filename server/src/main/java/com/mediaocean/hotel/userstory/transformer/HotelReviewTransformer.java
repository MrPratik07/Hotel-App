package com.mediaocean.hotel.userstory.transformer;

import com.mediaocean.hotel.userstory.dto.HotelReviewDto;
import com.mediaocean.hotel.userstory.model.HotelReview;
import com.mediaocean.hotel.userstory.service.HotelDetailService;
import com.mediaocean.hotel.userstory.service.HotelDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelReviewTransformer {

    @Autowired
    private HotelDetailService hotelDetailService;

    public HotelReviewDto entityToDto(HotelReview hotelReview){

        HotelReviewDto dto=new HotelReviewDto();

        dto.setId(hotelReview.getId());
        dto.setHotelid(hotelReview.getHotelDetail().getId());
        dto.setCheckin(hotelReview.getCheckin());
        dto.setRating(hotelReview.getRating());
        dto.setSummary(hotelReview.getSummary());
        dto.setDetails(hotelReview.getDetails());
        dto.setName(hotelReview.getName());
        return dto;

    }

    public List<HotelReviewDto> entityToDto(List<HotelReview> hotelReview){

        return  hotelReview.stream().map(hotelReviewObj->entityToDto(hotelReviewObj)).collect(Collectors.toList());
    }

    public HotelReview dtoToEntity(HotelReviewDto hotelReviewDto){

        HotelReview hotelReview=new HotelReview();
        hotelReview.setId(hotelReviewDto.getId());
        hotelReview.setHotelDetail(hotelDetailService.getHotelsById(hotelReviewDto.getHotelid()));
        hotelReview.setCheckin(hotelReviewDto.getCheckin());
        hotelReview.setRating(hotelReviewDto.getRating());
        hotelReview.setSummary(hotelReviewDto.getSummary());
        hotelReview.setDetails(hotelReviewDto.getDetails());
        hotelReview.setName(hotelReviewDto.getName());
        return  hotelReview;
    }

    public List<HotelReview> dtoToEntity(List<HotelReviewDto> hotelReviewDto){

        return  hotelReviewDto.stream().map(hotelReviewObj->dtoToEntity(hotelReviewObj)).collect(Collectors.toList());
    }
}
