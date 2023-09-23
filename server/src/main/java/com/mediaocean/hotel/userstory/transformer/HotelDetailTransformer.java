package com.mediaocean.hotel.userstory.transformer;

import com.mediaocean.hotel.userstory.dto.HotelDetailDto;
import com.mediaocean.hotel.userstory.model.HotelDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelDetailTransformer {
    public HotelDetailDto entityToDto(HotelDetail hotelDetail){

        HotelDetailDto dto=new HotelDetailDto();

        dto.setId(hotelDetail.getId());
        dto.setName(hotelDetail.getName());
        dto.setAddress(hotelDetail.getAddress());
        dto.setZip(hotelDetail.getZip());
        dto.setCity(hotelDetail.getCity());

        return dto;

    }

    public List<HotelDetailDto> entityToDto(List<HotelDetail> hotelDetail){

        return  hotelDetail.stream().map(hotelDetailObj->entityToDto(hotelDetailObj)).collect(Collectors.toList());
    }



    public HotelDetail dtoToEntity(HotelDetailDto hotelDetailDto){

        HotelDetail hotelDetail =new HotelDetail();
        hotelDetail.setId(hotelDetailDto.getId());
        hotelDetail.setName(hotelDetailDto.getName());
        hotelDetail.setAddress(hotelDetailDto.getAddress());
        hotelDetail.setZip(hotelDetailDto.getZip());
        hotelDetail.setCity(hotelDetailDto.getCity());

        return hotelDetail;
    }

    public List<HotelDetail> dtoToEntity(List<HotelDetailDto> hotelDetailDto){

        return  hotelDetailDto.stream().map(hotelDetailObj->dtoToEntity(hotelDetailObj)).collect(Collectors.toList());
    }
}
