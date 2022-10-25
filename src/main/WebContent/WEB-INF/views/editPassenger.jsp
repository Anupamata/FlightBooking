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
        <h2>Edit Details</h2>
        <form:form action="/FlightBooking/passenger/passengerSave" method="post" modelAttribute="passenger">
            <table border="0" cellpadding="5" >
                <tr>
                    <td>ID: </td>
                    <td>${passenger.passengerId}
                        <form:hidden path="passengerId"/>
                    </td>
                </tr>
                <tr>
                    <td>Passenger Name: </td>
                    <td><form:input path="passengerName" /></td>
                </tr>
                <tr>
                    <td>Username: </td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td><form:input path="gender" /></td>
                </tr>
                <tr>
                    <td>Mobile Number: </td>
                    <td><form:input path="mobileNumber" /></td>
                </tr>
                <tr>
                    <td>Passport Number: </td>
                    <td><form:input path="passportNumber" /></td>
                </tr>
                <tr>
                    <td>Address ID: </td>
                    <td>${passenger.idAddress}</td>
                        <form:hidden path="idAddress"/>

                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
             <a href="/FlightBooking/passenger/editAddress?id=${passenger.idAddress}">Edit Address Details</a>
        </form:form>
        <h3>Booked Ticket Details</h3>
                <form:form  method="post" modelAttribute="bookedTickets">

                            <table border="1" cellpadding="5">

                                <tr>
                                    <td>Flight ID: </td>
                                    <td>${bookedTickets.flightId}</td>
                                </tr>
                                <tr>
                                    <td>Seats Reserved: </td>
                                    <td>${bookedTickets.seatsReserved}</td>
                                </tr>
                                <tr>
                                    <td>Boarding Point: </td>
                                    <td>${bookedTickets.boardingPoint}</td>
                                </tr>
                                <tr>
                                    <td>Destination: </td>
                                    <td>${bookedTickets.destination}</td>
                                </tr>

                            </table>
                </form:form>

        </br><button onclick="history.back()"> Back</button>
    </div>
</body>
</html>