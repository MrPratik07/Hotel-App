package com.mediaocean.hotel.userstory.Repo;

import com.mediaocean.hotel.userstory.model.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<HotelReview, Integer> {

    @Query("From HotelReview where hotelDetail.city= :city")
    List<HotelReview> findReviewsByRatingAndCity(String city);
}


