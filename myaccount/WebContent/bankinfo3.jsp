<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: left;
}
</style>
<title>bankinfo</title>
</head>
<body bgcolor="#ffffee">

	<form method = "post" action="/myaccount/bi3">
		<fieldset>
			<legend style="font-size: 150%;">Bank Information : </legend>
			
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
				<label>FirstName</label> <input type="text"	name="firstname" value = "<%= request.getSession().getAttribute("firstName")%>"> 
				<br> 
				<br>
				<label>Bank Name</label> <input type="text" name="bankname">
				<br>
				<br> 
				<label>Account No.</label> <input type="number"	name="accountnumber">
				<br>
			    <br> 
			    <label>SSN</label> <input type="password" name="ssn">
			    <br> 
			    <br>
				<br> 
				<center>	
				<input type="submit" value="Submit" style="margin: 0 34%">
				<input type="button" onClick="location.href = '/myaccount/home.jsp'" value = "Home Page" style="margin: 0 -32%">
			</center>
			</div>
		</fieldset>
	</form>
</body>
</html>