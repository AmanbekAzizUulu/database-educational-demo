<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>FLights information</title>
</head>
<body>
	<h1>Flights information</h1>
	<div>
		<p>Size: ${requestScope.flights.size()}</p>
		<p>Flight ID: ${requestScope.flights.get(0).id()}</p>
		<p>Description: ${requestScope.flights.get(0).description()}</p>
		<br>
		<br>
		<hr>
		<br>
		<br>
		<p>JSESSIONID: ${cookie["JSESSIONID"].name} ${cookie["JSESSIONID"].value}</p>
		<p>PARAM ID: ${param.userName}</p>
		<p>HEADER ID: ${header["cookie"]}</p>
		<p>NOT EMPTY: ${not empty flights}</p>
	</div>
</body>
</html>
