<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
    <div align="center">
        <h2>Passenger Details</h2>
        <form:form  method="post" modelAttribute="flightDetails">
            <table border="1" cellpadding="5">
                <tr>
                    <td>Flight ID: </td>
                    <td>${flightDetails.flightId}
                </tr>
                <tr>
                    <td>Flight Name: </td>
                    <td>${flightDetails.flightName}</td>
                </tr>
                <tr>
                    <td>Source: </td>
                    <td>${flightDetails.source}</td>
                </tr>
                <tr>
                    <td>Destination: </td>
                    <td>${flightDetails.destination}</td>
                </tr>
                 <tr>
                     <td>Arrival Time: </td>
                     <td>${flightDetails.arrivalTime}</td>
                 </tr>
                <tr>
                    <td>Departure Time: </td>
                    <td>${flightDetails.departureTime}</td>
                </tr>
                <tr>
                    <td>Seats: </td>
                    <td>${flightDetails.seats}</td>
                </tr>
            </table>

        </form:form>

	</br><button onclick="history.back()"> Back</button></body>

    </div>
</html>