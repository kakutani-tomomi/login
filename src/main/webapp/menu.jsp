<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<%
	String name = (String) session.getAttribute("name");
	%>
	<h1><%=name%>さんがログイン中です。</h1>
	<h2>メニュー画面</h2>
	
	<form action="EmployeeDatail" method="post">
	<input type="text" name="id" placeholder="idを入力してください。">
	<input type="submit" value="検索">
	</form>
</body>
</html>