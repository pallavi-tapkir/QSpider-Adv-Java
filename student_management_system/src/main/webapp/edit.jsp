<%@page import="student_management_system.dto.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Student student= ( Student)request.getAttribute("student") ; %>
<form action="edit" method="post">
id:<input name="id" type="text" value="<%=student.getId() %>" readonly="true">
Name : <input type="text" name="name" placeholder="Enter name">
Address : <input type="text"  name="address" placeholder="Enter address">
Email : <input type="email"  name="email" placeholder="Enter email">
password:<input name="password" type="password" placeholder ="Enter password" >
<input type="submit">
</form>
</body>
</html>