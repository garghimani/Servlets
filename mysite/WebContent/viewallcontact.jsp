<%@include file="header.html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View All Contacts</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>View All Contacts</h2>
	</center>
	<!--Body: view all information-->
	<center>

		<table border="1" cellpadding="1" cellspacing="0" width="100%"">
			<tr>
				<th>Email Address</th>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>Home Phone</th>
				<th>Work Phone</th>
				<th>Mobile Phone</th>
				<th>GroupID</th>
			</tr>
			<c:forEach var="emailAddress" items="${emaillist}">
				<tr>
					<td><c:out value="${emailAddress.eMailID}"></c:out>
					<td><c:out value="${emailAddress.fName}"></c:out>
					<td><c:out value="${emailAddress.mName}"></c:out>
					<td><c:out value="${emailAddress.lName}"></c:out>
					<td><c:out value="${emailAddress.hPhone}"></c:out>
					<td><c:out value="${emailAddress.wPhone}"></c:out>
					<td><c:out value="${emailAddress.mPhone}"></c:out>
					<td><c:out value="${emailAddress.groupID}"></c:out>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>



</html>
<%@include file="footer.html"%>

</body>
