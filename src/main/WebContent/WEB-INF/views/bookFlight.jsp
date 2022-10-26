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
        <h2>Book Tickets</h2>
        <form:form  method="post" modelAttribute="newBookedTicket" action="/FlightBooking/passenger/newTicket/${newBookedTicket.flightId}">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Passenger ID: </td>
                    <td>${newBookedTicket.passengerId}
                        <form:hidden path="passengerId"/>
                    </td>
                </tr>
                <tr>
                    <td>Flight ID: </td>
                    <td>${newBookedTicket.flightId}
                        <form:hidden path="flightId"/>
                    </td>
                </tr>
                <tr>
                    <td>Boarding Point: </td>
                    <td><form:input path="boardingPoint" /></td>
                </tr>
                <tr>
                    <td>Destination: </td>
                    <td><form:input path="destination" /></td>
                </tr>

                <tr>
                    <td>Seats Reserved: </td>
                    <td><form:input path="seatsReserved" /></td>
                </tr>
            </table>
                 <input style="height:50px;width:120px" type="submit"  value="Save"/>
        </form:form>
      </br><button onclick="history.back()"> Back</button>
    </div>
</body>
</html>