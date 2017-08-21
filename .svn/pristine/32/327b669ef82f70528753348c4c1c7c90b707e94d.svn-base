<%@include file="include.jsp"%>
<%@include file="must.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Update Details</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 200px;
	height: 22px;
	text-align: right;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<center>
		<h1>Developers Forum</h1>
		<br /> <br /> <br /> <b>Edit Details </b><br /> <br />
		<div>
			<form:form method="post" action="eupdate" modelAttribute="regBean">
				<table>


					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName" value="${regBean.firstName}"
								pattern="[A-Za-z]{1,20}" title="only alphabets  MAXLENGTH=20" />
						</td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" value="${regBean.lastName}"
								pattern="[A-Za-z]{1,20}" title="only alphabets MAXLENGTH=20 " />
						</td>
					</tr>
					<tr>
						<td>Mobile Number :</td>
						<td><form:input path="mobileNumber"
								value="${regBean.mobileNumber}" pattern="[0-9]{10}"
								title="Enter 10 digit mobile number" minlength="10"
								maxlength="10" /></td>
					</tr>
					<tr>
						<td></td>
						<td><form:input path="" type="submit" value="Save"></form:input>
						</td>
					</tr>
				</table>
				<form:hidden path="emailId" value="${loggedInUser}" />

			</form:form>
		</div>
	</center>
</body>
</html>