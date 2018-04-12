<%-- 
    Document   : NewBookingView
    Created on : Mar 28, 2018, 7:46:33 PM
    Author     : Brian Morehouse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make new booking</title>
    </head>
    <body>
        <h1>Make a new booking</h1>
        <form>
            <p>Select Location:   </p>
            <select name="Location">
                <option>Location 1</option>
                <option>Location 2</option>
                <option>Location 3</option>
                <option>Location 4</option>
                <option>Location 5</option>
            </select><br><br><br>
            <p>Select Room Number:   </p>
            <select name="RoomNumber">
                <option>Room 1</option>
                <option>Room 2</option>
                <option>Room 3</option>
                <option>Room 4</option>
                <option>Room 5</option>
                <option>Room 6</option>
            </select><br><br><br>
            <p>Select Date:   </p>
            <input type="date" name="Date"><br><br><br>
            <p>Select Start Time:   </p>
            <input type="time" name="StartTime" step="1800" min="8:00" max="19:30"><span class="validity"></span><br><br><br>
            <p>Select End Time:   </p>
            <input type="time" name="EndTime" step="1800" min="8:30" max="20:00"><span class="validity"></span><br><br><br>
            
            <input type="submit" value="Submit" name="Submit" />
            </select>
        </form>
        
        
        
    </body>
</html>
