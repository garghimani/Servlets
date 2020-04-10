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
<title>contactinfo</title>
</head>
<body bgcolor="#ffffee">

	<form method = "post" action="/myaccount/cs3">
		<fieldset>
			<legend style="font-size: 150%;">Contact Information : </legend>
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
				 <label>Address</label> <textarea name="address" rows="2" cols="15"></textarea>
				 <br>
				 <br>
				 <label>City</label> <input type="text"	name="city">
				 <br> 
				 <br> 
				 <label>State</label> <input type="text" name="state">
				 <br> 
				 <br>
				 <label>Country</label> <input type="text" name="country">
				 <br>
				 <br> 
				 <label>Phone</label> <input type="text" name="phone"><br>
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