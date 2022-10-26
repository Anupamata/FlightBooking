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

        <h2>Details of all Flights</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Flight ID</th>
                <th>Flight Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Arrival Time</th>
                <th>Departure Time</th>
                <th>Seats</th>
                <th>Date</th>
                <th>Price</th>
                <th>Action</th>


            </tr>
            <c:forEach items="${flightDetailsList}" var="flightDetails">
            <tr>
                <td>${flightDetails.flightId}</td>
                <td>${flightDetails.flightName}</td>
                <td>${flightDetails.source}</td>
                <td>${flightDetails.destination}</td>
                <td>${flightDetails.arrivalTime}</td>
                <td>${flightDetails.departureTime}</td>
                <td>${flightDetails.seats}</td>
                <td>${flightDetails.date}</td>
                <td>${flightDetails.price}</td>
                <form modelAttribute="passenger" >
                <td><a href="/FlightBooking/passenger/bookTicket/${passenger.passengerId}/${flightDetails.flightId}">Book Now</a></td></form>

            </tr>
            </c:forEach>
        </table>

    </div>
    </body>
    </html>