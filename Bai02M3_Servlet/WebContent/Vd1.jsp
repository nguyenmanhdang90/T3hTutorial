<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ghi chu: Ví dụ 1 minh hoa ve JSP tags --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 1</title>
<%!
	int a = 3;
	int cong(int x, int y) {
		return x + y;
	}
%>
</head>
<body>
	a =	<%=a%><br>
	<%
		int b = 15;
		int tong = cong(a, b);
	%>
	tong = <%=tong%>
</body>
</html>