package com.mediaocean.hotel.userstory.service;

import com.mediaocean.hotel.userstory.dto.HotelReviewDto;

import java.util.List;

public interface HotelReviewService {

    List<HotelReviewDto> getReviews();
    List<HotelReviewDto> getReviewsByCityAndRating(String city);

}
