<%--
  Created by IntelliJ IDEA.
  User: vshinde
  Date: 10/20/2021
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>

<body>
<h1>Select City:</h1>

    <select id="city" name="city">
        <option value="None"> </option>
        <option value="Mumbai">Mumbai</option>
        <option value="Pune">Pune</option>
        <option value="Solapur">Solapur</option>
        <option value="Indapur">Indapur</option>
        <option value="Latur">Latur</option>
    </select>

    <h2>Min.avg_Ratings:</h2>
<div class="Drop_downlist">
    <label for="ratings">Ratings</label>
<select id="ratings" input type="ratings" class="form-control"  name="ratings">
    <option value="Average">Average</option>
    <option value="Good">Good</option>
    <option value="Excellent">Excellent</option>
    <option value="Terrible">Terrible</option>
    <option value="Poor">Poor</option>
</select>
</div>

<table class="table">
<div class="css-table">
<div class="css-table-header">
<div class="form">
    <thead>
    <center>
        <tr>

            <th>Name</th>
            <th>avg_rating</th>
            <th>Address</th>
            <th>Zip Code</th>

        </tr>
    </center>
    </thead>
</div>

<c:forEach var="hotelDetail" items="${rating}" >

    <tbody>
    <tr>

    <div class="css-table-body">
    <div class="css-table-row">

    <td>${hotelDetail.getName()}</td>
    <td>${hotelDetail.getRating()}</td>
    <td>${hotelDetail.getAddress()}</td>
    <td>${hotelDetail.getZipCode()}</td>


    </div>

    </div>

        </c:forEach>
    </tr>

    </tbody>
</body>
</html>
