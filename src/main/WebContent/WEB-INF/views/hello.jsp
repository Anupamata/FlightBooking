<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
${message}
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
   <form method="get"  action="/FlightBooking/"></br>
        <input style="height:50px;width:120px" type="submit"  value="   Log Out   "/></form>
    </center>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a>

</body>
</html>