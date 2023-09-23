import React from 'react';
import './Navbar.css'

function Navbar(){
    return(
        <div class="topnav">
        <a class="active" href="/">Home</a>
        <a href="/addreview">Add Review</a>
        <a href="/checkreview">Reviews</a>
        <a href="/checkhotel">Hotels</a>
        </div>
    )
}

export default Navbar;