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
			<form:form method="post" action="update" modelAttribute="regBean">
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
						<td>Password :</td>
						<td><form:input path="password" value="${regBean.password}"
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="txtPassword"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</td>
					</tr>
					<tr>
						<td>User Type Id :</td>
						<td><form:input path="userTypeId"
								value="${regBean.userTypeId}" pattern="[1-2]{1}"
								title="Enter 1 to change role as admin OR 2 for member "
								minlength="1" maxlength="1" /></td>
					</tr>
					<tr>
						<td>User State:</td>
						<td><form:input path="userState" value="${regBean.userState}"
								pattern="[inactive]*[active]*{6,8}"
								title="enter \"active\" for Account Activation OR \"inactive\" for Deactivation " />
						</td>
					</tr>

					<tr>
						<td></td>
						<td><form:input path="" type="submit" value="Save"></form:input>
						</td>
					</tr>
				</table>
				<form:hidden path="emailId" value="${regBean.emailId}" />

			</form:form>
		</div>
	</center>
</body>
</html>