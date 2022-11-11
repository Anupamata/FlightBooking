    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
        Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
    </head>
    <body>
    <div align="center">
    <h2>FLIGHT &nbsp; BOOKING &nbsp;SYSTEM</h2><br>
        <form method="get" action="/FlightBooking/officer/login">
            <input style="height:50px;width:120px" type="submit" value="OFFICER"/></td><br> <br>
        </form>
        <form method="get" action="/FlightBooking/passenger/login">
            <input style="height:50px;width:120px" type="submit" value="PASSENGER"/></td>
        </form>
    </div>

    <br><br>
    <a href="helloworld">Click here to read hello message </a><br/><a href="admin">Admin Page </a>
   </body>
   </html>
