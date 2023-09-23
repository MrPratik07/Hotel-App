<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<center><h1>Search The Hotels By Using Cities</h1></center>

<center>
    <h1>Select City:</h1>
    <form name="f1" method="Post">
<select id="city" name="city">
    <option value="None"> </option>
    <option value="Mumbai">Mumbai</option>
    <option value="Pune">Pune</option>
    <option value="Solapur">Solapur</option>
    <option value="Indapur">Indapur</option>
    <option value="Latur">Latur</option>
</select>
<input type="submit" value="Search" onclick="return Validate()" onchange="Validate();" />
<script type="text/javascript">
    function Validate() {
     const sel = document.getElementByAddress('address');


        if (sel.value == "") {

            alert("Please select a City!");
            return false;
        }
       else if (sel.value == "Mumbai") {


            alert(sel.value);


        }
        else if (sel.value == "Pune") {

            alert(sel.value);

        }
        else if (sel.value == "Solapur") {

            alert(sel.value);

        }
        else if (sel.value == "Indapur") {

            alert(sel.value);

        }
        else if (sel.value == "Latur") {

            alert(sel.value);

        }

        return true;
    }
</script>
    </form>

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
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Zip Code</th>

                                </tr>
                            </center>
                            </thead>
                        </div>
                        <c:forEach var="hotelDetail" items="${hotelDetails}" >

                        <tbody>
                        <tr>

                            <div class="css-table-body">
                                <div class="css-table-row">
                                    <td>${hotelDetail.getId()}</td>
                                    <td>${hotelDetail.getName()}</td>
                                    <td>${hotelDetail.getAddress()}</td>
                                    <td>${hotelDetail.getZipCode()}</td>


</div>

</div>
</tr>
</tbody>
</div>
</center>
</div>
</tr>


</c:forEach>


</center>
</table>




</body>
</html>