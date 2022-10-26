<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>Add New Person</h2>
        <form:form action="/FlightBooking/officer/saveFlight" method="post" modelAttribute="flightDetails">
            <table border="0" cellpadding="5">

                <tr>
                    <td>Flight Name: </td>
                    <td><form:input path="flightName" /></td>
                </tr>
                <tr>
                    <td>Source: </td>
                    <td><form:input path="source" /></td>
                </tr>
                <tr>
                    <td>Destination: </td>
                    <td><form:input path="destination" /></td>
                </tr>
                <tr>
                    <td>Arrival Time: </td>
                    <td><form:input path="arrivalTime" /></td>
                </tr>
                <tr>
                    <td>Departure Time: </td>
                    <td><form:input path="departureTime" /></td>
                </tr>

                <tr>
                    <td>Seats: </td>
                    <td><form:input path="seats" /></td>
                </tr>
                <tr>
                    <td>Date: </td>
                    <td><form:input path="date" /></td>
                </tr>

                <tr>
                    <td>Price: </td>
                    <td><form:input path="price" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="SAVE"></td>
                </tr>
            </table>
            </form:form>
	       </br><button onclick="history.back()"> Back</button>
    </div>
</body>
</html>