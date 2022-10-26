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
        <form:form  method="post" modelAttribute="passenger">
            <table border="1" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${passenger.passengerId}
                        <form:hidden path="passengerId"/>
                    </td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td>${passenger.passengerName}</td>
                </tr>
                <tr>
                    <td>Username: </td>
                    <td>${passenger.username}</td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td>${passenger.password}</td>
                </tr>
                 <tr>
                     <td>Gender: </td>
                     <td>${passenger.gender}</td>
                 </tr>
                <tr>
                    <td>Mobile Number: </td>
                    <td>${passenger.mobileNumber}</td>
                </tr>
                <tr>
                    <td>Passport Number: </td>
                    <td>${passenger.passportNumber}</td>
                </tr>
            </table>

        </form:form>
<h3>Address Details</h3>
        <form:form  method="post" modelAttribute="address">

                    <table border="1" cellpadding="5">

                        <tr>
                            <td>House Name: </td>
                            <td>${address.houseName}</td>
                        </tr>
                        <tr>
                            <td>City: </td>
                            <td>${address.city}</td>
                        </tr>
                        <tr>
                            <td>State: </td>
                            <td>${address.state}</td>
                        </tr>
                        <tr>
                            <td>Pin Code: </td>
                            <td>${address.pin}</td>
                        </tr>

                    </table>
        </form:form>

	</br><button onclick="history.back()"> Back</button></body>

    </div>
</html>