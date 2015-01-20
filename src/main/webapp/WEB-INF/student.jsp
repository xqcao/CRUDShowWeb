<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Students Data</h1>
	<form:form action="student.do" method="POST" commandName="student">
		<table>
			<tr>
				<td>Student ID</td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td>First name</td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Year Level</td>
				<td><form:input path="yearLevel" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" /> <input
					type="submit" name="action" value="Delete" /> <input type="submit"
					name="action" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<table border="1">
		<th>ID</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Year level</th>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.yearLevel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>