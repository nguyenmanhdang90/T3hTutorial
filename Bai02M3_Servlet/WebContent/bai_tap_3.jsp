<%@page import="helper.CSDL"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập 3</title>
<%!
	Connection ketNoi = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	String sql = "select s.ten_sua,s.hinh,s.trong_luong,s.don_gia,h.ten_hang_sua,l.ten_loai "
			+"from sua s inner join hang_sua h on h.ma_hang_sua = s.ma_hang_sua "
			+"inner join loai_sua l on l.ma_loai_sua = s.ma_loai_sua";
%>
<%
	stm = ketNoi.createStatement();
	rs  = stm.executeQuery(sql);
%>
</head>
<body>
<table border="1">
	<tr>
		<th colspan="2">THÔNG TIN CÁC SẢN PHẨM</th>
	</tr>
	<%while(rs.next()){ %>
		<tr>
			<td><img src="images/<%=rs.getString("hinh") %>"></td>
			<td>
				<p><b><%=rs.getString("ten_sua") %></b></p>
				<p>Nhà sản xuất: <%=rs.getString("ten_hang_sua") %></p>
				<p><%=rs.getString("ten_loai") %> - <%=rs.getInt("trong_luong") %> gr - <%=rs.getInt("don_gia") %> VNĐ</p>
			</td>
		</tr>
	<%} %>
</table>
</body>
</html>