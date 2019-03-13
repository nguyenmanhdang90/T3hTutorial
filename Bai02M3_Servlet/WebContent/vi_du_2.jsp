<%@page import="java.util.*"%>
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
	
	//bien mang
	int[] b = {1,5,2,3,4};
	request.setAttribute("b", b);
	
	//danh sach
	List<String> ds = new ArrayList<>();
	ds.add("mai");
	ds.add("lan");
	ds.add("cuc");
	ds.add("truc");
	session.setAttribute("ds", ds);
	
	//anh xa
	Map<String,String> td = new TreeMap<>();
	td.put("abstract","Trừu tượng");
	td.put("class","Lớp");
	td.put("interface","Giao tiếp");
	pageContext.setAttribute("td", td);
%>
</head>
<body>
5+3 = <%=5+3 %><br>
5+3 = ${5+3}<br>
a = <%= a %><br>
a = ${a }<br>
Họ tên: <%=request.getParameter("hoTen") %><br>
Họ tên: ${param.hoTen }<br>
b[1] = <%=b[1] %><br>
b[1] = ${b[1] }<br>
ds[3] = <%=ds.get(3) %><br>
ds[3] = ${ds[3] }<br>
td["class"] = <%=td.get("class") %><br>
td["class"] = ${td["class"] }
</body>
</html>