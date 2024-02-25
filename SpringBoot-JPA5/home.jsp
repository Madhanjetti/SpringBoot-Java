<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="add">
		Id : <input type="text" name="eid"> <br>
		Name : <input type="text" name="ename"> <br>
		Salary : <input type="text" name="salary"> <br>
		<input type="submit" value="INSERT">
	</form>
	
	
	<br>
	
	<form action="selectRow">
		Id : <input type="text" name="eid"> <br>
		<input type="submit" value="SELECT">
	</form>
	
	
</body>
</html>