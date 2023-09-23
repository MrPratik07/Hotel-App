import React, { useState,useEffect } from 'react';
import "./AddReview.css";

import axios from 'axios';
function AddReview(){

    const[review,setReview]=useState({
        checkin:"",
        rating:"",
        summary:"",
        details:"",
        name:""
        
    })
    const[record,setRecord]=useState([])
    const[hoteldetail,setHotelDetail]=useState([]);
    const[hotel, setHotel]=useState({});

    
   
    function handleInput(e){
        const name=e.target.name;
        const value=e.target.value;
        setReview({...review,[name]:value,name:hotel.name});
    }

    function saveReview(e){
        e.preventDefault();
        const reviews={...review,id:new Date().getTime().toString()}
        setRecord([...record,reviews])
        fetch(`http://localhost:9000/${hotel.id}/review`, {
            method: "POST",
            headers:{
                "Content-type":"application/json"
            } ,
            body: JSON.stringify(review)
            
          }).then(res => {
            alert("Review Added Successfully");
            setReview({
                checkin: "",
                rating:"",
                summary: "",
                details: "",
                name:"",
            })

          });
    }

    useEffect(()=>{
        axios.get(`http://localhost:9000/hoteldetails`,{
        })
        .then((response)=>{
           setHotelDetail(response.data);
        })
    },[]);

    return(
        <div className="main-form">
            <div className="review-form">
                <h1>Please Add your views on Hotel!!</h1>
                <form className="form" onSubmit={saveReview}>
                    <label>Hotel</label>
                    
                    <select name="name" id="hotel" onChange={e=>  setHotel(JSON.parse(e.target.value))} required>
                    <option selected>Select the Hotel</option>
                        {
                            hoteldetail.map(item=> <option value={JSON.stringify(item)}>{item.name}</option>)
                        }                        
                    </select>
    
                    <label>Checkin</label>
                    <input  id="checkin" type="date"  name="checkin" placeholder="01/01/2000" value={review.checkin} onChange={handleInput} required/>
    
                    <label>Rating</label >
                    <select name="rating" id="rating" value={review.rating} onChange={handleInput} required>
                        <option value="none" selected hidden>Select the Rating</option>
                        <option value="Good">Good</option>
                        <option value="Average">Average</option>
                        <option value="Bad">Bad</option>
                    </select>
    
                    <label>Summary</label>
                    <textarea id="summary" type="text" name="summary" placeholder="summary" value={review.summary} onChange={handleInput} required></textarea>
    
                    <label>Details</label>
                    <textarea id="details" type="text" name="details" placeholder="details" value={review.details} onChange={handleInput} required></textarea>
    
                    <div className="button">
                        <button id="submit">Submit</button>
                    </div>
                    </form>
                    </div>
                    
        </div>
        
                     
    )
}

export default AddReview;