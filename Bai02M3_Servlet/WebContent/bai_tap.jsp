<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tính tổng 2 số nguyên</title>
<%
	String sn1="", sn2="", kq="";
	if(request.getParameter("btnTinhTong")!=null){
		sn1 = request.getParameter("txtSN1");
		sn2 = request.getParameter("txtSN2");
		int k = Integer.parseInt(sn1)+Integer.parseInt(sn2);
		kq = Integer.toString(k);
	}
%>
</head>
<body>
<form action="" method="get">
	<table>
		<tr>
			<td>Số nguyên thứ nhất:</td>
			<td><input type="text" name="txtSN1" value="<%=sn1%>"/></td>
		</tr>
		<tr>
			<td>Số nguyên thứ hai:</td>
			<td><input type="text" name="txtSN2" value="<%=sn2%>"/></td>
		</tr>
		<tr>
			<td>Kết quả:</td>
			<td><input type="text" name="txtKQ" value="<%=kq%>"/></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<input type="submit" name="btnTinhTong" value="Tính tổng"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>