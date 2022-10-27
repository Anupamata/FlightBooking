    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
        Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
    <div align="center">

        <h2>Details of  Booked Flights</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Booking ID</th>
                <th>Passenger ID</th>
                <th>Flight ID</th>
                <th>Boarding Point</th>
                <th>Destination</th>
                <th>Seats Reserved</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${bookedDetails}" var="bookedTickets">
            <tr>
                <td>${bookedTickets.bookingId}</td>
                <td>${bookedTickets.passengerId}</td>
                <td>${bookedTickets.flightId}</td>
                <td>${bookedTickets.boardingPoint}</td>
                <td>${bookedTickets.destination}</td>
                <td>${bookedTickets.seatsReserved}</td>
                <td>${bookedTickets.price}</td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <h2>Details of Passengers</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Passenger ID</th>
                <th>Passenger Name</th>
                <th>Passport Number</th>
                <th>username</th>
                <th>Password</th>
                <th>Mobile Number</th>
                <th>Gender</th>
                <th>Address ID</th>
            </tr>
            <c:forEach items="${passengerDetailsList}" var="passenger">
            <tr>
                <td>${passenger.passengerId}</td>
                <td>${passenger.passengerName}</td>
                <td>${passenger.passportNumber}</td>
                <td>${passenger.username}</td>
                <td>${passenger.password}</td>
                <td>${passenger.mobileNumber}</td>
                <td>${passenger.gender}</td>
                <td>${passenger.idAddress}</td>
            </tr>
            </c:forEach>
        </table>

</br><button onclick="history.back()"> Back</button>
    </div>
    </body>
    </html>