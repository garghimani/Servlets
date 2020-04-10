<!DOCTYPE html>
<html>
<head>
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
	width: 250px;
	text-align: left;
}

input[type="text"] {
	display: inline-block;
	float: left;
}

input[type="radio"] {
	margin: 0 1%;
}
</style>
<meta charset="ISO-8859-1">
<title>personalinfo</title>
</head>
<body bgcolor="#ffffee">
	<form method = "post" action="/myaccount/pi3">
		<fieldset>
			<legend style="font-size: 150%;"> Personal Information : </legend>
			<div>
			<font color = red>
			<% 
				Object obj  =request.getAttribute("errMsg");
				String errs;
				if(obj != null){
				errs = (String) obj;

				%>
				<%= errs %>
				<% } %>
				</font>
				<br> 
				<br> 
				<label>FirstName</label> <input type="text"	name="firstname"> 
				<br> 
				<br> 
				<label>MiddleName</label> <input type="text" name="middlename">
				<br> 
				<br> <label>LastName</label> <input type="text" name="lastname">
				<br> 
				<br>
				<br> 
				<label>Gender</label> <input type="radio" name="gender"	value="male" checked>Male
				                      <input type="radio" name="gender" value="female">Female
				<br> 
				<br> 
			    <br>
			<center>	
				<input type="submit" value="Submit">
				<input type="button" onClick="location.href = '/myaccount/home.jsp'" value = "Home Page">
			</center>	
			</div>
		</fieldset>
	</form>
</body>
</html>



