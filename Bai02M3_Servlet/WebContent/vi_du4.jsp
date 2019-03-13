<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javaBeans.LoaiSua"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 2 EL</title>
<%
	LoaiSua ls1 = new LoaiSua();
	ls1.setMaLoai("S1");
	ls1.setTenLoai("Sữa S1");

	LoaiSua ls2 = new LoaiSua();
	ls2.setMaLoai("S2");
	ls2.setTenLoai("Sữa S2");

	LoaiSua ls3 = new LoaiSua();
	ls3.setMaLoai("S3");
	ls3.setTenLoai("Sữa S3");

	List<LoaiSua> dsls = new ArrayList<>();
	dsls.add(ls1);
	dsls.add(ls2);
	dsls.add(ls3);
	request.setAttribute("dsls", dsls);
%>
</head>
<body>
<%for(LoaiSua ls:dsls){ %>
	<p>Mã loại: <%=ls.getMaLoai() %> - Tên loại: <%=ls.getTenLoai() %></p>
<%} %>
<br>
<c:forEach items="${dsls}" var="ls">
	<p>Mã loại: ${ls.maLoai } - Tên loại: ${ls.tenLoai }</p>
</c:forEach>
</body>
</html>