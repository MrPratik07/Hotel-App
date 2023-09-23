package com.mediaocean.hotel.userstory.controller;
import com.mediaocean.hotel.userstory.dto.HotelDetailDto;
import com.mediaocean.hotel.userstory.dto.HotelReviewDto;
import com.mediaocean.hotel.userstory.service.HotelDetailServiceImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mediaocean.hotel.userstory.service.HotelReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HotelController {

    @Autowired
    HotelDetailServiceImpl hotelDetailServiceImpl;

    @Autowired
    HotelReviewServiceImpl hotelReviewServiceImpl;

    // This is Home page
    @RequestMapping("/")
    public String greet() {
        return "Welcome to Home Page";
    }

    // Get the Hotel details by City
    @RequestMapping(value = "/{city}/hoteldetails")
    public List<HotelDetailDto> getHotelDetails(@PathVariable(value = "city") String city) {
        List<HotelDetailDto> hotelDetails = hotelDetailServiceImpl.getHotels();
        hotelDetails = hotelDetails.stream().filter(hotelDetail -> hotelDetail.getCity().equals(city)).collect(Collectors.toList());
        return hotelDetails;
    }

    // Get all the Hotel details
    @RequestMapping(value = "/hoteldetails")
    public List<HotelDetailDto> getHotelDetails() {
        List<HotelDetailDto> hotelDetails = hotelDetailServiceImpl.getHotels();
        return hotelDetails;
    }

    // Get the Hotel reviews as per City and Rating
    @RequestMapping(value = "/{city}/hotelreviews/{rating}")
    public List<HotelReviewDto> getHotelReviews(@PathVariable(value= "rating") String rating, @PathVariable(value = "city") String city) {
        List<HotelReviewDto> hotelReviews = hotelReviewServiceImpl.getReviewsByCityAndRating(city);
        hotelReviews = hotelReviews.stream().filter(hotelReview -> hotelReview.getRating().equals(rating)).collect(Collectors.toList());
        return hotelReviews;
    }

    // Get all the Hotel reviews
    @RequestMapping(value = "/hotelreviews")
    public List<HotelReviewDto> getHotelReviews() {
        List<HotelReviewDto> hotelReviews = hotelReviewServiceImpl.getReviews();
        return hotelReviews;
    }

    // Post the Reviews
    @PostMapping(value = "/{hotelid}/review")
    public String addReviews(@RequestBody HotelReviewDto hotelReviewDto, @PathVariable(value= "hotelid") int hotelid) {
        hotelReviewDto.setHotelid(hotelid);
        hotelReviewServiceImpl.addReview(hotelReviewDto);
        return "added Successful";
    }

    //delete the review by id
    @DeleteMapping(value = "/review/{id}")
    public String deleteReview(@PathVariable(value = "id") int id){
        hotelReviewServiceImpl.deleteHotelById(id);
        return "delete Successful";
    }

    //update the review
    @PutMapping(value = "/review/update/{id}")
    public String updateReview(@PathVariable(value = "id") int id, @RequestBody HotelReviewDto hotelReviewDto){
        hotelReviewServiceImpl.updateHotelById(id,hotelReviewDto);
        return "update Successful";
    }


}










