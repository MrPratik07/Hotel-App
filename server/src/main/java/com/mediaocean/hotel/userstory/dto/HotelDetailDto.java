package com.mediaocean.hotel.userstory.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HotelDetailDto {
    private int  id;
    private String name;
    private String address;
    private int zip;
    private String city;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                '}';
    }



    public HotelDetailDto(){
        super();
    }


    public HotelDetailDto(int id, String name, String address, int zip, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city=city;
    }
}
