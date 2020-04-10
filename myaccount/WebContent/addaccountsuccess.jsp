<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuccesfullyRegistered</title>
</head>
<body>
	<center>
		<h1>
			<font color=red>You've Registered Successfully</font>
		</h1>
	</center>
	<center>
		<h3>
			<font>Personal Details</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>
				<td><c:out value="${addpinfo.firstName}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>
				<td><c:out value="${addpinfo.middleName}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>
				<td><c:out value="${addpinfo.lastName}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Gender</td>
				<td><c:out value="${addpinfo.gender}"></c:out></td>
			</tr>
		</table>
		<h3>
			<font>Contact Information</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Address</td>
				<td><c:out value="${addcinfo.address}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">City</td>
				<td><c:out value="${addcinfo.city}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">State</td>
				<td><c:out value="${addcinfo.state}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Country</td>
				<td><c:out value="${addcinfo.country}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Phone Number</td>
				<td><c:out value="${addcinfo.phone}"></c:out></td>
			</tr>
		</table>
		<h3>

			<font>Account Details</font>
		</h3>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Bank Name</td>
				<td><c:out value="${addbinfo.bankName}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Account No.</td>
				<td><c:out value="${addbinfo.accountNumber}"></c:out></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">SSN</td>
				<td><c:out value="${addbinfo.ssn}"></c:out></td>
			</tr>
		</table>
		<br> <br> <input type="button"
			onClick="location.href = '/myaccount/home.jsp'" value="Home Page"
			style="margin: 0 34">
	</center>
</body>
</html>