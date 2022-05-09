<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	
	<div>
		<h1>Danh Sách Sinh Viên</h1>
	</div>
	<p style="color: red;">"${error}"</p>
	<div>
		<a href="CreateUser">Create new</a>
	</div>
	<div>
		<table
			style="width: 1000px; margin: auto; width: 50%; border-collapse: collapse"
			border="1" cellpadding="5" cellspacing="5">

			<tr>
				<th>Mã
				<th><p>Username</th>
				<th><p>Password
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<th>${user.id}</th>
					<th>${user.username}</th>
					<th>${user.password}</th>
					<th><a href="EditUser?id=${user.id}"> Sửa <br>
						<a href="DeleteUser?id=${user.id}" onclick="return confirm('xóa nhé?')"> Xóa </a></th>
				</tr>
			</c:forEach>


		</table>
	</div>
</body>
</html>