package com.mediaocean.hotel.userstory.Repo;
import com.mediaocean.hotel.userstory.model.HotelDetail;
import com.mediaocean.hotel.userstory.model.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<HotelDetail,Integer> {

    HotelDetail searchById(int id);

}

