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
            ${dropdown}
            <br><br><br>
            <p>Select Date:   </p>
            <input type="date" name="Date"><br><br><br>
            <p>Select Start Time:   </p>
            <input type="time" name="StartTime" step="1800" min="8:00" max="19:30" ><span class="validity" ></span><br><br><br>
            <p>Select End Time:   </p>
            <input type="time" name="EndTime" step="1800" min="8:30" max="20:00"><span class="validity"></span><br><br><br>
            ${errorMessage}
            <input type="submit" value="Submit" name="Submit" />
            
    </form>
            <h4><a href="http://localhost:8080/MorehouseFinalProject/Main">Back to Main Menu</a></h4>
                    
        
    </body>
</html>
