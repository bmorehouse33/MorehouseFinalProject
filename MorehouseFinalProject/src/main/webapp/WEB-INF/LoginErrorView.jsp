<%-- 
    Document   : LoginErrorView
    Created on : Mar 28, 2018, 7:47:41 PM
    Author     : Brian Morehouse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <h3>Invalid Username or Password. Try again</h3> <br>   
    <form method="post">  
    UserName:<input type="text" name="username"/>
    <br/><br/>  
    Password:<input type="password" name="password"/>
    <br/><br/>  
    <input type="submit" value="login"/>  
    </form>
    </body>
</html>
