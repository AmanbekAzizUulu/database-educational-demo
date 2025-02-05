<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<%@ page import="com.dandaevit.edu.jdbc.service.TicketService" %>
<%@ page import="com.dandaevit.edu.jdbc.dto.TicketDTO" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page</title>
</head>
<body>
	<h1>List of sold Ticket</h1>

	<%-- <ul> --%>
		<%-- <% --%>
	    	<%-- // TicketService ts = TicketService.getInstance(); --%>
	    	<%-- // String flightIdStr = request.getParameter("flightId"); --%>

	    	<%-- // if (flightIdStr != null && !flightIdStr.isEmpty()) { --%>
	    	<%-- //     int flightId = Integer.parseInt(flightIdStr); --%>
	    	<%-- //     out.write("<table border='1'>"); --%>
	    	<%-- //     out.write("<tr><th>Имя пассажира</th><th>Номер места</th><th>Стоимость</th></tr>"); --%>

	    	<%-- //     for (TicketDTO ticketDTO : ts.getTicketsByFlightId(flightId)) { --%>
	    	<%-- //         out.write(String.format( --%>
	    	<%-- //             "<tr><td>%s</td><td>%s</td><td>%s</td></tr>", --%>
	    	<%-- //             ticketDTO.passengerName(), --%>
	    	<%-- //             ticketDTO.seat().getSeatNo(), --%>
	    	<%-- //             ticketDTO.price() --%>
	    	<%-- //         )); --%>
	    	<%-- //     } --%>

	    	<%-- //     out.write("</table>"); --%>
	    	<%-- // } else { --%>
	    	<%-- //     out.write("<p>Ошибка: flightId не передан.</p>"); --%>
	    	<%-- // } --%>

		<%-- %> --%>
	<%-- </ul> --%>

	<ul>
		<c:if test="${not empty requestScope.tickets}">
			<table border='1'>
				<tr>
					<th>Имя пассажира</th>
					<th>Номер места</th>
					<th>Стоимость</th>
				</tr>
				<c:forEach var="ticket" items="${requestScope.tickets}">
					<tr>
						<td>${fn:toUpperCase(ticket.passengerName())}</td>
						<td>${ticket.seat().getSeatNo()}</td>
						<td>${ticket.price()}</td>
					</tr>

				</c:forEach>
			</table>
		</c:if>
	</ul>
</body>
</html>
