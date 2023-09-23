<%--
  Created by IntelliJ IDEA.
  User: vshinde
  Date: 10/19/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <center><h2>Add Review For Hotel:</h2></center>

    <form action="#" method="post">
        <div class="form-group" >
            <label for="Check_in Date">Check_in Date</label>
            <input type="check_in Date" class="form-control" id="Check_in Date" placeholder="check_in Date" name="checkin" required/>
        </div>
        <div class="Drop_downlist">
            <label for="ratings">Ratings</label>
            <select id="ratings" input type="ratings" class="form-control"  name="rating">
                <option value="Average">Average</option>
                <option value="Good">Good</option>
                <option value="Excellent">Excellent</option>
                <option value="Terrible">Terrible</option>
                <option value="Poor">Poor</option>
            </select>

        </div>

        <div class="form-group">
            <label for="Summary">Summary</label>
            <input type="summary" class="form-control" id="Summary" placeholder="Summary" name="summary" required/>
        </div>
        <div class="form-group">
            <label for="Details">Details</label>
            <input type="Details" class="form-control" id="Details" placeholder="Details" name="details"/>
        </div>
        <div class="form-group">
            <label for="City">City</label>
            <input type="City" class="form-control" id="City" placeholder="City" name="city"/>
        </div>
        <center>
            <button type="Submit" class="btn btn-default">Save_review</button>

        </center>


    </form>
</div>

</body>
</html>
