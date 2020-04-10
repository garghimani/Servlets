<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>personaldetailssuccess</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Personal Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<jsp:useBean id="pinfoVO" class="account.dbaccess.PersonalInfoVOO"
			scope="request">
		</jsp:useBean>
		<table border="1" cellpadding="1" cellspacing="0" width="25%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
				<td><jsp:getProperty name="pinfoVO" property="firstName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
				<td><jsp:getProperty name="pinfoVO" property="middleName" /></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
				<td><jsp:getProperty name="pinfoVO" property="lastName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Gender</td>
				<td><jsp:getProperty name="pinfoVO" property="gender" /></td>
			</tr>
			
		</table>
		<br>
		<br>
				
		<input type="button" onClick="location.href = '/myaccount/home.jsp'" 
			   value = "Home Page" style="margin: 0 34">

	</center>
</body>
</html>