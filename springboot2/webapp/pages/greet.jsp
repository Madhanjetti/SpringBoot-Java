<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>greet</title>
</head>
<body>

You have Logined in Successfully
<br>
<%
session=request.getSession();
String x=(String)session.getAttribute("abc");
out.println("Name is :"+x);
%>

</body>
</html>