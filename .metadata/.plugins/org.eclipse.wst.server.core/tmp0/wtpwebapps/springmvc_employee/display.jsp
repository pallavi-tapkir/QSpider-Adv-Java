<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<th>id</th>
<th>name</th>
<th>salary</th>
<th>address</th>
<th>delete</th>
<th>edit</th>
</tr>
<c:forEach var="employee" items="${list}">
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.salary}</td>
<td>${employee.address}</td>
<td><a href="delete?id=${employee.id}">delete</a></td>
<td><a href="edit?id=${employee.id}">edit</a></td>



</tr>


</c:forEach>






</table>
</body>
</html>
