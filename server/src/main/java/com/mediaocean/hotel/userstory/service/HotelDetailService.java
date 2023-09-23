package com.mediaocean.hotel.userstory.service;

import com.mediaocean.hotel.userstory.dto.HotelDetailDto;
import com.mediaocean.hotel.userstory.model.HotelDetail;

import java.util.List;

public interface HotelDetailService {

    List<HotelDetailDto> getHotels();
    HotelDetail getHotelsById(int id);

}
