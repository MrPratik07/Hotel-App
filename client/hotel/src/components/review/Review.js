import React, { useState,useEffect } from 'react';
import axios from 'axios';
import './Review.css';
import moment from 'moment';
import {RiDeleteBin6Line,RiEditLine} from 'react-icons/ri'



function Review({props}){
    const[review,setReview]=useState([]);
    let[citylist,setCityList]=useState([]);
    const [rating,setRating]=useState("");
    const[city,setCity]=useState("");
    //const[hotelid,setHotelId]=useState("");

    // sort the Review Data by Date
    function sortReviewByDate(a, b) {
        return new Date(a.checkin).getTime() - new Date(b.checkin).getTime();
    }

    
    //delete the Review
    function deleteReview(i){
        axios.delete(`http://localhost:9000/review/${i.id}`)
        .catch((exception)=> console.log(exception))
        window.location.reload(false);    
    } 
                
    useEffect(()=>{
    axios.get(`http://localhost:9000/hoteldetails`,{
    })
    .then((response)=>{
            var citydata=response.data
            const result = [...citydata.reduce((m, o) => m.set(o.city, o), new Map()).values()]
            setCityList(result);
        })
    },[]);

    useEffect(()=>{
        axios.get(`http://localhost:9000/${city}/hotelreviews/${rating}`,{
        }).then((response)=>{

            setReview((response.data).sort(sortReviewByDate));
        })
    },[city,rating]);

    


    return(
    <div className="table"> 
    <h1>Check the Reviews</h1>
    <div className="dropdown-input">
        <div>

    <label> Select City : </label >
    <select name="city" id="city-review" onChange={(e)=> setCity(e.target.value)}>
    <option value="none" selected disabled>Select an City</option>
        {
            
            citylist.map(item =><option value={item.city}>{item.city}</option>)
        }
        
    </select>

        </div>

        <div>

    <label> Select Rating : </label >
    <select name="rating" id="rating-review" onChange={(e)=> setRating(e.target.value)}>
    <option value="none" selected disabled>Select an Rating</option>
        <option value="Good">Good</option>
        <option value="Average">Average</option>
        <option value="Bad">Bad</option>
    </select>
        </div>
    </div>
    {   review.length> 0 ?
    <table>
        <thead>
    <tr>
        <th scope="col">Hotel Name</th>
        <th scope="col">Rating</th>
        <th scope="col">Checkin</th>
        <th scope="col">Summary</th>
        <th scope="col">Details</th>
        <th scope="col">Delete</th>
        <th scope="col">Edit</th>
    </tr>
     </thead>
     <tbody>   
    { 

         review.map((i)=> <tr key={i.id}>
        <td>{i.name}</td>
        <td>{i.rating}</td>
        <td>{moment(i.checkin).format('DD/MM/YYYY')}</td>
        <td>{i.details}</td>
        <td>{i.summary}</td>
        <td id="delete-logo" onClick={()=>deleteReview(i)}>{<RiDeleteBin6Line/>}</td>
        <td id="edit-logo">{<RiEditLine/>}</td>
        </tr>) 
    
    }
    </tbody>
    </table>
    : <p>No Data Found For The Given Input</p>
} 
    <div className="buttons">
        <button className="review-button" onClick={event =>  window.location.href='/addreview'}>Add Review</button>
        <button className="allreview-button" onClick={event =>  window.location.reload(false)}>All Reviews</button>
    </div>
    </div>
    );
}

export default Review;



