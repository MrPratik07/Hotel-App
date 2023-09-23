<%--
  Created by IntelliJ IDEA.
  User: vshinde
  Date: 10/12/2021
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<p>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    .myDiv {
        border: 3px outset darkred;
        background-color: chocolate;
        text-align: center;
    }
    p.ex1{

        padding:10px;
    }
    input.right{
        float: right;
    }
    input.left{
        float: left;
    }
    p.ex2{
        border:1px solid red;
        padding:35px;
    }
    table thead {
        font-weight: bold;
        background-color: rgb(191, 191, 191);
    }

    table th, table td {
        padding: 0 6px;
        text-align: center;
    }


    /* CSS TABLE STYLES */

    .css-table {
        display: table;
    }

    .css-table-header {
        display: table-header-group;
        font-weight: bold;
        background-color: rgb(191, 191, 191);
    }

    .css-table-body {
        display: table-row-group;
    }

    .css-table-row {
        display: table-row;
    }

    .css-table-header div,
    .css-table-row div {
        display: table-cell;
        padding: 0 6px;
    }

    .css-table-header div {
        text-align: center;
        border: 1px solid rgb(255, 255, 255);
    }
</style>
</head>
<p>

    <div class="myDiv">
    <p class="ex1">

        <h1><p><b>W Lexiton Hotel</b></p></h1>
    </div>
</p>
<table>
    <p class="ex1">
<center>
    <div class="bs-example">
        <table class="table">
            <div class="css-table">
                <div class="css-table-header">
                    <div class="form">
            <thead>
            <center>
            <tr>
                <th>Id</th>
                <th>Ratings</th>
                <th>Trip_type</th>
                <th>check In</th>
                <th>Summary</th>
                <th>Details</th>
            </tr>
            </center>
            </thead>
                </div>
            <c:forEach var="review" items="${reviews}" >

            <tbody>
            <tr>

                <div class="css-table-body">
                    <div class="css-table-row">
                        <td>${review.getId()}</td>
                        <td>${review.getRating()}</td>
                        <td>${review.getTrip_type()}</td>
                        <td>${review.getDate()}</td>
                        <td>${review.getSummary()}</td>
                        <td>${review.getDetails()}</td>
                        </center>
                    </div>
                </div>
            </tr>
            </tbody>
            </div>

            </div>
            </tr>


                </c:forEach>



        </table>
</p>
    </div>
<p class="ex1">

    <a href="/addreview">
         <input type="button" value="Add Review" class="left"/>
    </a>
    <a href="/">
        <input type="button" value="Close" class="right" />
    </a>











</table>
</center>
</body>
</html>
