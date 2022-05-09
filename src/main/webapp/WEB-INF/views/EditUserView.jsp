<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto; width: 50%">
		<form action="EditUser" method="post">
		<table border="1" style="border-collapse: collapse;" cellpadding="5"
			cellspacing="5">
			<tr>
				<th>ID</th>
				<th><input type="text" name="id" value="${user.id}" readonly="readonly">
			</tr>

			<tr>
				<th>Username</th>
				<th><input type="text" name="username" value="${user.username}">
			</tr>


			<tr>
				<th>Password</th>
				<th><input type="text" name="password" value="${user.password}">
			</tr>


			<tr>
				<th colspan="2"><input type="submit" value="submit">
			</tr>
		</table>


	</form>
	</div>
</body>
</html>