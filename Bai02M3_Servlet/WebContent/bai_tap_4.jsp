<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="helper.CSDL"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập 4</title>
<%!
	Connection ketNoi = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	String sql = "select * from sua";
	Locale lc = new Locale("vi","VN");
	NumberFormat nf = NumberFormat.getNumberInstance(lc);
%>
<%
	stm = ketNoi.createStatement();
	rs =stm.executeQuery(sql);
	int sc=1;
%>
<style>
	td{
		vertical-align: top;
		text-align: center;
		width:180px;
	}
	img{
		width:100px;
		height:100px;
	}
</style>
</head>
<body>
<table border="1">
	<tr><th colspan="5">THÔNG TIN CÁC SẢN PHẨM</th></tr>
	<%while(rs.next()){ %>
		<%if(sc++==1){ %><tr><%} %>
		<td>
			<p><b><%=rs.getString("ten_sua") %></b></p>
			<p><%=rs.getInt("trong_luong") %> gr - <%=nf.format(rs.getInt("don_gia")) %> VNĐ</p>
			<p><img src="images/<%=rs.getString("hinh") %>"></p>
		</td>
		<%if(sc==6){sc=1; %></tr><%} %>
	<%} %>
	<%if(sc!=1){ %></tr><%} %>
</table>
</body>
</html>