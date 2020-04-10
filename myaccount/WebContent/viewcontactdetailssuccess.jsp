<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contactdetailssuccess</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Contact Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<jsp:useBean id="cinfoVO" class="account.dbaccess.ContactInfoVOO"
			scope="request">
		</jsp:useBean>
		<table border="1" cellpadding="1" cellspacing="0" width="25%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Address</td>
				<td><jsp:getProperty name="cinfoVO" property="address" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">City</td>
				<td><jsp:getProperty name="cinfoVO" property="city" /></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Sate</td>
				<td><jsp:getProperty name="cinfoVO" property="state" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Country</td>
				<td><jsp:getProperty name="cinfoVO" property="country" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Phone</td>
				<td><jsp:getProperty name="cinfoVO" property="phone" /></td>
			</tr>
			
		</table>
		
		<br>
		<br>
				
		<input type="button" onClick="location.href = '/myaccount/home.jsp'" 
			   value = "Home Page" style="margin: 0 34">

	</center>
</body>
</html>