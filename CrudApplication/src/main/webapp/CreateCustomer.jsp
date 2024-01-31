<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% 
    	String Authontication = (String) session.getAttribute("obj");
    
    	if(Authontication!="login-auth"){
    		response.sendRedirect("index.jsp");
    	}
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Customer</title>

<%@include file="BootStrap/style.css" %>
<%@include file="BootStrap/NavigationBar.jsp" %>

<style type="text/css">
	
.customerForm{
	margin-left: 50px;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-right: 50px;
	border: 1px solid;
}

.form-row{
	margin-left: 10px;
	margin-right: 10px;
}

form button{
	background: #437fc7;
}

form button:hover {
	background: linear-gradient(#437fc7, #e580ff);
}

.btn{
	width: 200px;
	margin-top: 20px;
	background: #437fc7;
	margin-left: 610px;
	font-family: Times New Roman;
	font-size: 20px;
	color: white;
}

.btn:hover{
	background: linear-gradient(#437fc7, #e580ff);
}

.btn a{
	text-decoration: none;
	color: white;
}

</style>

</head>
<body>

	<%
		String msg = (String) session.getAttribute("succmsg");
	%>
	
	<script type="text/javascript">
	
	var message = "<%=msg%>";
	
	if(message=="success"){
		
		swal("Success", "Customer Registration Sucessfull", "success");
		
	}else if(message=="faild"){
		
		swal("Error", "Customer Registration Faild", "error");
		
	}
	
	</script>

	<%session.removeAttribute("succmsg"); %>


	<button class="btn"><a href="ViewCustomer.jsp">View Customer</a></button>
	
<div class="customerForm">
<form action="AddCustomer" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label >First Name</label>
      <input type="text" class="form-control" placeholder="First Name" required="required" name="firstname">
    </div>
   
    <div class="form-group col-md-6">
      <label>Last Name</label>
      <input type="text" class="form-control" placeholder="Last Name" required="required" name="lastname">
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label >Street</label>
      <input type="text" class="form-control" placeholder="Street" required="required" name="street">
    </div>
    
    <div class="form-group col-md-6">
      <label>Address</label>
      <input type="text" class="form-control" placeholder="Address" required="required" name="address">
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>City</label>
      <input type="text" class="form-control" placeholder="City" required="required" name="city">
    </div>
    
    <div class="form-group col-md-6">
      <label>State</label>
      <input type="text" class="form-control" placeholder="State" required="required" name="state"> 
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Email Id</label>
      <input type="email" class="form-control" placeholder="Email@id" required="required" name="email">
    </div>
    
    <div class="form-group col-md-6">
      <label>Phone</label>
      <input type="text" class="form-control" placeholder="Phone" required="required" name="phone">
    </div>
  </div>
  
  	<br>
  <div class="form-row">
  
    <button>Submit</button>  
  </div>
  
  	
</form>
	
	</div>


</body>
</html>