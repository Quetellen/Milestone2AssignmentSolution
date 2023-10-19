<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zumba Classes</title>
<link rel="icon" href="pictures/faviconzumba.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Update Batch</h1>
	<form name="frmBatch" action="update">
		<table>
			<tr>
				<td><input type="text" name="b_id" id="box3" readonly
					value="<%out.print(request.getAttribute("b_id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" class="box2"
					value="<%out.print(request.getAttribute("name"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="startTime" class="box1"
					value="<%out.print(request.getAttribute("startTime"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endTime" class="box1"
					value="<%out.print(request.getAttribute("endTime"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="shift" class="box1"
					value="<%out.print(request.getAttribute("shift"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Save" class="button" onclick="validate()">
	</form>
	<script src="scripts/validate.js"></script>
</body>
</html>