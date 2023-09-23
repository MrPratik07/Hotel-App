package com.mediaocean.hotel.userstory.service;
import com.mediaocean.hotel.userstory.Repo.HotelRepository;
import com.mediaocean.hotel.userstory.dto.HotelDetailDto;
import com.mediaocean.hotel.userstory.model.HotelDetail;
import java.util.List;

import com.mediaocean.hotel.userstory.transformer.HotelDetailTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class HotelDetailServiceImpl implements HotelDetailService{

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelDetailTransformer hotelDetailTransformer;


    @Override
    public List<HotelDetailDto> getHotels() {
        List<HotelDetail> hotelDetails= hotelRepository.findAll();
        List<HotelDetailDto> hotelDetailDtos=hotelDetailTransformer.entityToDto(hotelDetails);
        return hotelDetailDtos;
    }

    @Override
    public HotelDetail getHotelsById(int id) {
        HotelDetail hotelDetail=hotelRepository.searchById(id);
        //HotelDetailDto hotelDetailDto=hotelDetailTransformer.entityToDto(hotelDetail);
        return hotelDetail;
    }




}

