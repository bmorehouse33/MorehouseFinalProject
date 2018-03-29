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
            <p>Select Date:   </p>
            <input type="date" name="Date"><br><br><br>
            <p>Select Time:   </p>
            <input type="time" name="Time"><br><br><br>
            
            <input type="submit" value="Submit" name="Submit" />
            </select>
        </form>
        
        
        
    </body>
</html>
