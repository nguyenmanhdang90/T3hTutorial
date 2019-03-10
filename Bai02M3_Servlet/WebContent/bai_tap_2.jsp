<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="helper.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập 2</title>
<%!
	Connection ketNoi = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	String sql = "select * from khach_hang";
%>
<%
	stm = ketNoi.createStatement();
	rs = stm.executeQuery(sql);
%>
<style>
	img{
		width:30px;
		height:30px;
	}
	td:nth-child(3){
		text-align:center;
	}
	tr:nth-child(even){
		background-color:pink;
	}
</style>
</head>
<body>
<table border="1">
	<caption>THÔNG TIN KHÁCH HÀNG</caption>
	<tr>
		<th>Mã KH</th>
		<th>Tên khách hàng</th>
		<th>Giới tính</th>
		<th>Địa chỉ</th>
		<th>Điện thoại</th>
	</tr>
	<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getString("ma_khach_hang") %></td>
			<td><%=rs.getString("ten_khach_hang") %></td>
			<td><img src="images/<%=rs.getBoolean("phai")?"nu.jpg":"nam.jpg"%>"></td>
			<td><%=rs.getString("dia_chi") %></td>
			<td><%=rs.getString("dien_thoai") %></td>
		</tr>
	<%} %>
</table>
</body>
</html>