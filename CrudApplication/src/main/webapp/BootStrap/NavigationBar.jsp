<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
<%@include file="style.css" %>
</title>

<style type="text/css">

.buttons{
	margin-left: 1150px;
	align-items: center;
}
button {
	margin-top: 2px;
	height: 47px;
	width: 100px;
	margin-right: 10px;
	border-radius: 20px;
	border: 1px;
}

button a{
	text-decoration: none;
	color: black;
	
}

button:hover {
	cursor: pointer;
	background-color: #3399ff;
}

</style>

</head>
<body>

<nav style=" background-color: #cccccc; width: 100%; height: 50px; ">
	<div class="buttons">
		<button><a href="index.jsp">Login</a></button>
		<button><a href="logoutServlet">Logout</a></button>
	</div>
</nav>

</body>
</html>