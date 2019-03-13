<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 1 EL</title>
<%
	//bien don
	int a=5;
	application.setAttribute("a", a);
%>
</head>
<body>
5+3 = <%=5+3 %><br>
5+3 = ${5+3}<br>
a = <%= a %><br>
a = ${a }
</body>
</html>