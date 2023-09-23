import React, { useEffect } from 'react'
import './HotelDetail.css'
import axios from 'axios';

import { useState } from 'react';

function HotelDetail(){
    let[hotel,setHotel]=useState([]);
    let[city,setCity]=useState([]);
    let[cityname,setCityName]=useState("");

    useEffect(()=>{
        axios.get(`http://localhost:9000/hoteldetails`,{
        })
        .then((response)=>{
            var citydata=response.data
            const result = [...citydata.reduce((m, o) => m.set(o.city, o), new Map()).values()]
            setCity(result);
        })
    },[]);
    
    
    useEffect(()=>{
        axios.get(`http://localhost:9000/${cityname}/hoteldetails`,{
        })
        .then((response)=>{
            var hotel=response.data;
            function SortByName(x,y) {
                return ((x.name === y.name) ? 0 : ((x.name > y.name) ? 1 : -1 ));
              }
            // Call Sort By Name
            hotel.sort(SortByName);
            setHotel(hotel);
        })
    },[cityname]);

    
    return(
    <div className="hotellist">
    
    <h1>Check Hotels By City</h1>
    
    <div className="city">
    <label for="city" id="citylabel">Choose a City:</label>
        <select name="city" id="city" onChange={(e)=> setCityName(e.target.value)}>
        <option value="none" selected disabled>Select an City</option>
            {
                   city.map(item => <option key={item.id}>{item.city}</option>)
                   
            }
        </select>
    </div>

    <div className="tab">
    <table>
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Zip</th>
    </tr>
    </thead>
    <tbody>
        {
            hotel.map((i)=>
                <tr key={i.id}>
                <td>{i.name}</td>
                <td>{i.address}</td>
                <td>{i.zip}</td>
                </tr>
        )}
    </tbody>
    </table>
    </div>
    </div>
    
   );
}

export default HotelDetail;