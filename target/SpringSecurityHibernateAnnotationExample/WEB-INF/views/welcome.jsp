<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
 <%

  %>
  <a href="<c:url value="/ewelina" />"><h3>go to ewelina page</h3></a>
  <a href="<c:url value="/logout" />">Logout</a>
	Greeting : ${greeting}
	This is a welcome page.
</body>
</html>
