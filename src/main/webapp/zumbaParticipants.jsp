<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Participant"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Participant> list = (ArrayList<Participant>) request.getAttribute("participant");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zumba Participants</title>
<link rel="icon" href="pictures/faviconzumba.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Zumba Participants</h1>
	<a href="NewParticipant.html" class="button">New Participant</a>
	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>PName</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Batch Id</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0 ; i < list.size(); i++){ %>
			<tr>
				<td><%=list.get(i).getP_id()%></td>
				<td><%=list.get(i).getPname()%></td>
				<td><%=list.get(i).getPhone()%></td>
				<td><%=list.get(i).getEmail()%></td>
				<td><%=list.get(i).getB_id()%></td>
				<td><a href="selectp?p_id=<%=list.get(i).getP_id()%>"
					class="button1"> Update </a> 
					<a href="javascript: confirmp(<%=list.get(i).getP_id()%>)"
					class="button2"> Delete </a> 
				<%} %>
		</tbody>
	</table>
	<script src="scripts/validateDeletionP.js"></script>
</body>
</html>