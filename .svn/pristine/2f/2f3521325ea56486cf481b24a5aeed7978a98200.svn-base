<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Forums Page with registration</title>
<head>
<style type="text/css">
body {
	background: linear-gradient(to bottom right, white, #bcbdc4);
	height: 750px;
}

.headerx {
	position: absolute;
	width: 100%;
	height: 70px;
	top: 0px;
	left: 0px;
	color: white;
	z-index: 7;
	font-family: verdana;
	-webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);
}

.header {
	position: absolute;
	width: 100%;
	height: 70px;
	background: #333333;
	top: 0px;
	left: 0px;
	color: white;
	z-index: 7;
	font-family: verdana;
}

#logo {
	height: 80;
	width: 100;
	left: 36%;
}

.main {
	position: absolute;
	width: 100%;
	height: 700px;
	background-image: url("background.png");
	background-repeat: no-repeat;
	background-size: cover;
	top: 70px;
	left: 0px;
	color: white;
	z-index: 20;
	font-family: verdana;
}

.box {
	margin-top: 20px;
	height: 480px;
	width: 350px;
	background: #efefef;
	padding-top: 15px;
	padding-left: 28px;
	padding-right: 28px;
	padding-bottom: 25px;
}

#info1 {
	text-align: center;
	color: black;
	font-family: arial;
	font-size: 20px;
}

#info2 {
	text-align: center;
	color: black;
	font-family: arial;
	font-size: 16px;
}

#info3 {
	text-align: left;
	color: #888889;
	font-family: arial;
	font-size: 12px;
}

#info4 {
	text-align: center;
	color: #888889;
	font-family: arial;
	font-size: 12px;
}

.button2 {
	width: 350px;
	height: 35px;
	top: 625px;
	background: #f1c218;
	font-family: verdana;
	font-size: 16px;
	font-weight: bold;
	color: black;
	border-radius: 5px 5px 5px 5px;
	border-width: 1px;
	border-style: solid;
	border-color: gray;
	cursor: pointer;
	outline: none;
}

.sub-footer {
	position: absolute;
	width: 100%;
	height: 20px;
	background: #474644;
	top: 500px;
	left: 0px;
	color: white;
	z-index: 20;
	font-family: verdana;
}

.box2 {
	color: white;
	height: 100px;
	width: 848px;
	background: #474644;
	padding-top: 15px;
	padding-left: 10px;
	padding-right: 10px;
	padding-bottom: 25px;
}

#submit2 {
	background: white;
	color: black;
	z-index: 20;
	height: 23px;
	width: 60px;
	cursor: pointer;
}

.footer {
	position: absolute;
	width: 100%;
	height: 80px;
	background: #000;
	top: 650px;
	left: 0px;
	color: white;
	z-index: 20;
	font-family: verdana;
}

.box3 {
	color: white;
	height: 50px;
	width: 1000px;
	padding-top: 10px;
	padding-left: 10px;
	padding-right: 10px;
	padding-bottom: 20px;
}

.box3 li {
	float: left;
	margin-right: 20px;
	font-size: 12px;
}
</style>



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
					<form:form name="home" method="post" action="registration"
						modelAttribute="regBean">

						<div id="info1">Share,Discuss,Learn</div>
						<br>
						<div id="info2">Get started - it's free.</div>
						<br>
						<div id="info3">Email Id</div>
						<!--An <input> element with type="email" that must be in the following order: characters@characters.domain (characters followed by an @ sign, followed by more characters, and then a "."
                           After the "." sign, you can only write 2 to 3 letters from a to z:-->
						<form:input type="email" path="emailId" name="emailId"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							style="width:350px; height:30px;"
							title="Email  must be in the following order: characters@characters.domain (characters followed by an @ sign, followed by more characters, and then a .
                           After the . sign, you can only write 2 to 3 letters from a to z" />
						<br>
						<br>
						<div id="info3">First Name</div>
						<form:input path="firstName" type="text" name="firstName"
							pattern="[A-Za-z]{1,20}" title="only alphabets MAXLENGTH=20"
							style="width:350px; height:30px;" />
						<br>
						<br>
						<div id="info3">Last Name</div>
						<form:input type="text" path="lastName" name="lastName"
							pattern="[A-Za-z]{1,20}" title="only alphabets MAXLENGTH=20"
							style="width:350px; height:30px;" />
						<br>
						<br>
						<div id="info3">Mobile Number</div>
						<form:input path="mobileNumber" type="text" name="mobileNumber"
							pattern="[0-9]{10}" title="Enter 10 digit mobile number"
							minlength="10" maxlength="10" style="width:350px;height:30px" />
						<br>
						<br>
						<div id="info3">Password (8 or more characters)</div>
						<form:input path="password" type="password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="txtPassword"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							style="width:350px;height:30px;" />
						<br>
						<br>
						<div id="info3">Confirm Password (8 or more characters)</div>
						<form:input path="" type="password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
							id="txtConfirmPassword"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							style="width:350px;height:30px;" />

						<br>
						<br>
						<form:input class="button2" path="" type="submit"
							value="Create account" onclick="return Validate()"></form:input>
						<br>
						<a href="login">Already Have an Account?</a>
					</form:form>
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

		<!--   Validate()  will be called if two passwords doesn't match 
   using javscript -->
		<script type="text/javascript">
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

        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }

</script>
</body>
</html>