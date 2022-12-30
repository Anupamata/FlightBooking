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
    <center>
    <h2>
    Welcome <i>${passenger.passengerName}</i><br></h2>
   <form method="get"  action="/FlightBooking/passenger/fetchPassengerById/${passenger.passengerId}"></br>
        <input style="height:50px;width:120px" type="submit"  value="View My Details"/></form>
   <form method="get"  action="/FlightBooking/passenger/edit/${passenger.passengerId}"></br>
        <input style="height:50px;width:120px" type="submit"  value="Edit  My Details"/></form>
   <form method="get"  action="/FlightBooking/passenger/fetchById"></br>
        <input style="height:50px;width:120px" type="submit"  value="Search for Flight"/></form>
   <form method="get"  action="/FlightBooking/passenger/availableTickets/${passenger.passengerId}"></br>
        <input style="height:50px;width:120px" type="submit"  value="   Ticket Booking   "/></form>
   <form method="GET"  action="/FlightBooking/passenger/cancel/${passenger.passengerId}"></br>
           <input style="height:50px;width:120px" type="submit"  value="   Ticket Cancel   "/></form>

        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <a href="${logoutUrl}">Log Out</a>
    </center>
    </body>
    </html>