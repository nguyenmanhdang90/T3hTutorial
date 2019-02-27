<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}">Module 3</a></div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="helloworld.html">Hello World</a></li>
			<li><a href="sumtwonumbers.html">Sum Two Numbers</a></li>
			<li><a href="summultinumbers.html">Sum Multiple Numbers</a></li>
			<li><a href="register.jsp">Register</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="multiplicationtable.jsp">Multiplication Table</a></li>
			<li><a href="upload.html">Upload Image</a></li>
			<li><a href="upload/multi.html">Multiple Upload Image</a></li>
			<li><a href="template.jsp">Template Example</a></li>
			<li><a href="category.html">Category</a></li>
		</ul>
	</div>
	<div class="main">
		<jsp:invoke fragment="content" />
	</div>
</body>
</html>
