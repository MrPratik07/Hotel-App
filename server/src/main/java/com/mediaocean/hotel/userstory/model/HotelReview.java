package com.mediaocean.hotel.userstory.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="hotelreview")
public class HotelReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date checkin;
    private String rating;
    private String summary;
    private String details;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelid")
    private HotelDetail hotelDetail;

    public HotelDetail getHotelDetail() {
        return hotelDetail;
    }

    public void setHotelDetail(HotelDetail hotelDetail) {
        this.hotelDetail = hotelDetail;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", checkin='" + checkin + '\'' +
                ", rating='" + rating + '\'' +
                ", summary='" + summary + '\'' +
                ", details='" + details + '\'' +
                ", name='" + name + '\'' +
                '}';
    }



    public HotelReview(){
        super();
    }

    public HotelReview(int id,Date checkin, String rating, String summary, String details,String name) {
        this.id = id;
        this.checkin = checkin;
        this.rating = rating;
        this.summary = summary;
        this.details = details;
        this.name=name;
    }








}
