<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>Username
				<td><input type="text" name="username">
			</tr>
			<tr>
				<td>Password
				<td><input type="text" name="password">
			</tr>
			<tr>
				<td><br> ${mess}
			</tr>
			<tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
               </td>
            </tr>
			
		</table>
	</form>
</body>
</html>