package com.mediaocean.hotel.userstory.service;

import com.mediaocean.hotel.userstory.Repo.ReviewRepository;
import com.mediaocean.hotel.userstory.dto.HotelDetailDto;
import com.mediaocean.hotel.userstory.dto.HotelReviewDto;
import com.mediaocean.hotel.userstory.model.HotelDetail;
import com.mediaocean.hotel.userstory.model.HotelReview;
import com.mediaocean.hotel.userstory.transformer.HotelReviewTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReviewServiceImpl  implements HotelReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    HotelReviewTransformer hotelReviewTransformer;

    @Override
    public List<HotelReviewDto> getReviews() {
       List<HotelReview> hotelReviews= reviewRepository.findAll();
       List<HotelReviewDto> hotelReviewDtos = hotelReviewTransformer.entityToDto(hotelReviews);
       return hotelReviewDtos;
    }

    @Override
    public List<HotelReviewDto> getReviewsByCityAndRating(String city){
        List<HotelReview> hotelReviews=reviewRepository.findReviewsByRatingAndCity(city);
        List<HotelReviewDto> hotelReviewDtos=hotelReviewTransformer.entityToDto(hotelReviews);
        return hotelReviewDtos;
    }

    public void deleteHotelById(int id){
        reviewRepository.deleteById(id);
    }

    public void updateHotelById(int id,HotelReviewDto hotelReviewDto){
        HotelReview hotelReview = reviewRepository.getById(id);
        hotelReview=hotelReviewTransformer.dtoToEntity(hotelReviewDto);
        reviewRepository.save(hotelReview);
    }


    public void addReview(HotelReviewDto hotelReviewDto) {
        HotelReview hotelReview=hotelReviewTransformer.dtoToEntity(hotelReviewDto);
        reviewRepository.save(hotelReview);
    }


}
