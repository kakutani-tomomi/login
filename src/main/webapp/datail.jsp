<%@page import="model.entity.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細情報</title>
</head>
<body>
	<%
	EmployeeBean bean = (EmployeeBean) request.getAttribute("bean");
	%>
	<h1>従業員情報</h1>
	<table>
		<tr>
			<td><%=bean.getId()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getHomeTown()%></td>
		</tr>
	</table>
</body>
</html>