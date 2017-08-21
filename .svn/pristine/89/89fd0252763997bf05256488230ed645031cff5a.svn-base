<%@include file="must.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<title>Forums Page with Login</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>

	<div class="headerx"></div>
	<div class="header">
		<div align="center" class="header">
			<h1>Developer's Forum</h1>
		</div>

		<div class="main">
			<center>
				<div class="box">
					<form:form name="home" method="post" action="login"
						modelAttribute="loginBean">

						<div id="info1">Share,Discuss,Learn</div>
						<br>
						<div id="info2">Get started - it's free.</div>
						<br>
						<div id="info">
							<font color="red">${message}</font>
						</div>
						<div id="info3">Email Id</div>
						<form:input type="username" path="" name="username"
							style="width:350px; height:30px;" />
						<br>
						<br>
						<div id="info3">Password (8 or more characters)</div>
						<form:input path="" type="password" name="password"
							style="width:350px;height:30px" />
						<br>
						<br>

						<form:input class="button2" path="" type="submit" value="Sign In"
							onclick="return Validate()" />
					</form:form>
					<br> <br>
					<div id="info3">Don't have an Account ?</div>
					<div class="button2">
						<a href="registration"
							style="text-decoration: none; color: black;"> Register </a>
					</div>
					<br> <br>
					<div id="info3">Continue as a Guest ?</div>
					<div class="button2">
						<a href="guestView" style="text-decoration: none; color: black;">
							Guest </a>
					</div>
				</div>
			</center>
		</div>
		<div class="footer">
			<center>
				<div class="box3">
					<p>
						<span style="font-size: 12px;">Thanks For Visiting Our
							Website</span>
					</p>
				</div>
			</center>
		</div>

		<!--   Validate()  will be called if emailId and password  is not filled by user when clicking sign in 
   using javscript -->
		<script>
function Validate() {
   var x = document.forms["home"]["emailId"].value;
   var y = document.forms["home"]["password"].value;
   if ( x == null || x == "" ) {
      alert("Email  Id must be filled out");
      return false;
   }
   if ( y == null || y == "" ) {
      alert("Password must be filled out");
      return false;
     
   }
}
</script>
</body>
</html>