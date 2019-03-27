<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sữa</title>
</head>
<body>
<table border="1">
	<tr>
		<th>Tên sữa</th>
		<th>Hãng sữa</th>
		<th>Loại sữa</th>
		<th>Trọng lượng</th>
		<th>Đơn giá</th>
	</tr>
	<c:forEach items="${dsSua}" var="sua">
		<tr>
			<td>${sua.tenSua }</td>
			<td>${sua.hangSua.tenHangSua }</td>
			<td>${sua.loaiSua.tenLoai }</td>
			<td>${sua.trongLuong }</td>
			<td>${sua.donGia }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>