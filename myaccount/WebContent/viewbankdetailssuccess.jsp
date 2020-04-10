<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bankdetailssuccess</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>Bank Details</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>
		<jsp:useBean id="binfoVO" class="account.dbaccess.BankInfoVOO"
			scope="request">
		</jsp:useBean>
		<table border="1" cellpadding="1" cellspacing="0" width="40%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Bank Name</td>
				<td><jsp:getProperty name="binfoVO" property="bankName" /></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Account Number</td>
				<td><jsp:getProperty name="binfoVO" property="accountNumber" /></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">SSN</td>
				<td><jsp:getProperty name="binfoVO" property="ssn" /></td>
			</tr>			
		</table>
		
		<br>
		<br>
				
		<input type="button" onClick="location.href = '/myaccount/home.jsp'" 
			   value = "Home Page" style="margin: 0 34">

	</center>
</body>
</html>