<%@page import="com.entity.CustomerEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


	<% 
    	String Authontication = (String) session.getAttribute("obj");
    
    	if(Authontication!="login-auth"){
    		response.sendRedirect("index.jsp");
    	}
    %>
    

<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer</title>
<%@include file="BootStrap/style.css" %>
<%@include file="BootStrap/NavigationBar.jsp" %>

<style type="text/css">

.addCustomerbtn button {
	margin-top: 50px;
	margin-left: 50px;
	width: 80px;
	background: #437fc7;
}
.addCustomerbtn button a{
	color: black;
	text-decoration: none;
	font-family: Times New Roman;
	font-size: 20px;
}

.addCustomerbtn button:hover {
	background: linear-gradient(#437fc7, #e580ff);
}

.row{
	margin-left: 50px; 
	margin-top: 20px;
	width: 900px;	
}









.addCustomerbtn button a{
	text-decoration: none;
	color: white;
}

.row button:hover {
	background: linear-gradient(#437fc7, #e580ff);
}
	
.card{
	margin-left: 60px;
	margin-right: 60px;
	margin-top: 30px;
	border: 1px solid;
	height: 350px;
	max-height: 350px;
	overflow: scroll;
}	


.customerForm{
	background-color: white;
	width: 700px;
	margin-left: 350px;
	border: 1px solid;
	top: -80%;
	position: absolute;
	border-radius: 10px;
}

.customerForm form{
	padding: 5px;
	margin-top: 10px;
}	

.customerForm span{
	position: absolute;
	right: 0px;
	height: 20px;
	width: 20px;
	background: green;
	text-align: center;
	font-size: 15px;
	font-weight: bold;
	border-top-right-radius: 7px;
}






.overlay{
	width: 100%;
	height: 100vh;
	top: 0%;
	position: absolute;
	background: rgba(0,0,0,0.5);
	opacity: 0;
	z-index: -1;
	
}

.customerForm button{
	background-color: #437fc7;
	color: white;
	margin-left: 250px;
}


/* ********************** */
/* Show Update Form CSS */


.showoverlay{
	opacity: 1;
	z-index: 1;
}


.show_customerForm{
	width: 700px;
	margin-left: 350px;
	border: 1px solid;
	top: 10%;
	position: absolute;
	border-radius: 10px;
	z-index: 1;
}


	
	
</style>

</head>
<body>

	<%
		String msg = (String) session.getAttribute("succmsg");
	%>

	<script type="text/javascript">
		var message = "<%=msg %>";
		
		if(message=="Update_success"){
			
			swal("Success", "Customer Update Sucessfull", "success");
			
		}else if(message=="Update_faild"){
			
			swal("Error", "Customer Update Faild", "error");
			
		}else if(message=="Delete_success"){
			
			swal("Success", "Customer Delete Sucessfull", "success");
			
		}else if(message=="Delete_faild"){
			
			swal("Error", "Customer Delete Faild", "error");
			
		}
		
	</script>

	<%session.removeAttribute("succmsg"); %>


	<div class="addCustomerbtn">
		<button><a href="ViewCustomer.jsp"><i class="fa-solid fa-angles-left"></i></a></button>
	</div>
	

	
	<div class="card">
	<table class="table table-bordered">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Action</th>
		
		</thead>
		
		<tbody>
			<%	
				String tableName = request.getParameter("table_name");
				String content = request.getParameter("content");
			
				CustomerDao dao = new CustomerDao(DBConnect.getconn());
				List<CustomerEntity> list = dao.SearchCustomer(tableName, content);
				
				for(CustomerEntity cust:list){
			%>
			<tr>
			
		
			
				<td hidden="hidden"><%=cust.getId() %></td>
				<td><%=cust.getFirstName() %></td>
				<td><%=cust.getLastName() %></td>
				<td><%=cust.getAddress() %></td>
				<td><%=cust.getCity() %></td>
				<td><%=cust.getState() %></td>
				<td><%=cust.getEmail() %></td>
				<td><%=cust.getPhone() %></td>
				<td><a href="#" onclick="ShowUpdateForm(<%=cust.getId()%>, '<%=cust.getFirstName() %>', '<%=cust.getLastName() %>', 
				'<%=cust.getStreet() %>', '<%=cust.getAddress() %>', '<%=cust.getCity() %>', '<%=cust.getState() %>',
				'<%=cust.getEmail() %>', '<%=cust.getPhone() %>',)"> <i class="fa-solid fa-user-pen"></i></a> 
				
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deletecustomer?cust_id=<%=cust.getId()%>" style="color: red;"> <i class="fa-solid fa-trash"></i></a></td>
				  
				  
			
			</tr>
			
			<%
				}
			%>
		
		</tbody>
		
		
		
	
	</table>
	</div>
	
	
<div class="overlay"></div>	
			
<div class="customerForm">

<span onclick="CloseUpdateForm()">&times;</span>

<form action="UpdateCustomer" method="post">

	
	
  <div class="form-row">
    <div class="form-group col-md-6">
      <label >First Name</label>
      <input hidden="hidden" name="id" id="Id">
      
      <input type="text" class="form-control" placeholder="First Name" id="EditFirstName" required="required" name="firstname">
    </div>
   
    <div class="form-group col-md-6">
      <label>Last Name</label>
      <input type="text" class="form-control" placeholder="Last Name" id="EditLastName" required="required" name="lastname">
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6" >
      <label >Street</label>
      <input type="text" class="form-control" placeholder="Street" id="EditStreet" required="required" name="street">
    </div>
    
    <div class="form-group col-md-6">
      <label>Address</label>
      <input type="text" class="form-control" placeholder="Address" id="EditAddress" required="required" name="address">
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>City</label>
      <input type="text" class="form-control" placeholder="City" id="EditCity" required="required" name="city">
    </div>
    
    <div class="form-group col-md-6">
      <label>State</label>
      <input type="text" class="form-control" placeholder="State" id="EditState" required="required" name="state"> 
    </div>
  </div>
  
  <br>
  
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Email Id</label>
      <input type="email" class="form-control" placeholder="Email@id" id="EditEmail" required="required" name="email">
    </div>
    
    <div class="form-group col-md-6">
      <label>Phone</label>
      <input type="text" class="form-control" placeholder="Phone" id="EditPhone" required="required" name="phone">
    </div>
  </div>
  
  	<br>
  <div class="form-row">
  
    <button>Update</button>  
  </div>
  
  	
</form>
	
	</div>
		
	
	
	
</body>


<script type="text/javascript">

	function ShowUpdateForm(id, firstname, lastname, street, address, city, state, email, phone) {
		
		
		
		document.getElementById('Id').value =  id;
		document.getElementById('EditFirstName').value = firstname;
		document.getElementById('EditLastName').value = lastname;
		document.getElementById('EditStreet').value = street;
		document.getElementById('EditAddress').value = address;
		document.getElementById('EditCity').value = city;
		document.getElementById('EditState').value = state;
		document.getElementById('EditEmail').value = email;
		document.getElementById('EditPhone').value = phone;
		
		document.querySelector('.overlay').classList.add('showoverlay');		
		document.querySelector('.customerForm').classList.add('show_customerForm');
		
	}

	
	
	function CloseUpdateForm() {
		document.querySelector('.overlay').classList.remove('showoverlay');		
		document.querySelector('.customerForm').classList.remove('show_customerForm');
		
	}
	
	
</script>





</html>