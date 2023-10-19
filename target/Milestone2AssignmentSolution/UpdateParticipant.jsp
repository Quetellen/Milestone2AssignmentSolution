<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="pictures/faviconzumba.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Update Participants</h1>
	<form name="frmParticipant" action="updatep">
		<table>
			<tr>
				<td><input type="text" name="p_id" id="box3" readonly
					value="<%out.print(request.getAttribute("p_id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="pname" class="box2"
					value="<%out.print(request.getAttribute("pname"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="phone" class="box2"
					value="<%out.print(request.getAttribute("phone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="box2"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="b_id" class="box1" readonly
					value="<%out.print(request.getAttribute("b_id"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Save" class="button" onclick="validatep()">
	</form>
	<script src="scripts/validateP.js"></script>
</body>
</html>