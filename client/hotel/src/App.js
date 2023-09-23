import React from 'react';
import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import HotelDetail from './components/hoteldetail/HotelDetail';
import Review from './components/review/Review';
import Home from './components/home/Home';
import AddReview  from './components/addreview/AddReview';
import Navbar from './components/navbar/Navbar';
function App() {
  return (
    <Router>
      <Navbar/>
      <Switch>
        <Route exact path="/" render={(props) => <Home {...props} />} />
        <Route exact path="/checkhotel" render={(props) => <HotelDetail {...props} />} />
        <Route exact path="/checkreview" render={(props) => <Review {...props} />} />
        <Route exact path="/addreview" render={(props) => <AddReview {...props} />} />
      </Switch>
    </Router>
  )
}

export default App;
