package com.mediaocean.hotel.userstory.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="hoteldetail")

public class HotelDetail {
    @Id
    private int id;
    private String name;
    private String address;
    private int zip;
    private String city;



    @OneToMany(mappedBy = "hotelDetail",cascade = CascadeType.ALL)
    private List<HotelReview> hotelReview;

    public List<HotelReview> getHotelReview() {
        return hotelReview;
    }

    public void setHotelReview(List<HotelReview> hotelReview) {
        this.hotelReview = hotelReview;
    }

    public HotelDetail() {
        super();
    }

    public HotelDetail(int id, String name, String address, int zip, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
    }





}
