<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div align="center"><H3>Search for a Flight</h3>    <BR>

Enter Flight ID: <input type="text" id="id"  >
<button onclick='window.location ="/FlightBooking/passenger/searchResult?id="+document.getElementById("id").value'>GET </button><br>
	                     </br><button onclick="history.back()"> Back</button>
    </div>
</body>
</html>