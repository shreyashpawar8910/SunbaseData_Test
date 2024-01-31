<html>
<head>
<%@include file="BootStrap/style.css" %>
<%@include file="BootStrap/NavigationBar.jsp" %>

<%@page import="com.DB.DBConnect" %>
<%@page import="java.sql.Connection" %>

<title>Login Page</title>

<style type="text/css">
.card{
	height: 420px;
	width: 430px;
	border: 1px solid;
	margin-left: 35%;
	margin-top: 6%;
	border-radius: 30px;
}

.header{
	height: 50px;
	text-align: center;
	background-color: #437fc7;
	border-top-left-radius: 30px;
	border-top-right-radius: 30px;
	margin: 4px;
}

.header h3{
	margin-top: 4px;
	font-family: Bodoni MT;
	color: white;
	font-size: 35px;
}

.form{
	margin: 10px;
}

.form label{
	margin-left: 8px;
	font-family: Times New Roman;
	font-size: 20px;
}

.form input{
	width: 100%;
	height: 35px;
	border-radius: 10px;
}

.form button{
	
	width: 100%;
	margin-top: 20px;
	background: #437fc7;
	font-family: Times New Roman;
	font-size: 25px;
}

.form button:hover {
	background: linear-gradient(#437fc7, #e580ff);
}

</style>

</head>

<body>
	
	
	 <%
    	
       String msg = (String)session.getAttribute("succmsg");
     		   
     %>
     
     <script type="text/javascript">
     	
     	var massage = "<%=msg%>";
     	if(massage=="faild"){
     		swal("Error","Incorrect Username Password", "error");		
     	}
     
     </script>
	
	<%session.removeAttribute("succmsg"); %>

	<div class="card">
		<div class="header"><h3>Login</h3></div>
		<br><br>
		<div class="form">
			<form action="login" method="post">
				<label>Username</label><br>
				<input type="text" name="username">
				<br><br>
						
				<label>Password</label><br>
				<input type="password" name = "password">
				<br><br>
				
				<button>Login</button>			
			
			</form>
		
		</div>
		
	</div>


</body>
</html>
