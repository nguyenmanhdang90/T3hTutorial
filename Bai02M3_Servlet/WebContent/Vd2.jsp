<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vd2</title>
</head>
<body>
<%
	application.setAttribute("congTy", "Alphatek");
	session.setAttribute("nguoiDung", "Tran Vi Tinh");
	request.setAttribute("maSV", "A01");
	pageContext.setAttribute("noiDung", "Minh hoạ về biến ẩn trong trang JSP");
%>
	Nguoi dung: <%=session.getAttribute("nguoiDung") %>
<%
	out.println("<br>Nguoi dung: "+session.getAttribute("nguoiDung"));
%>	
</body>
</html>