<%@include file="must.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ask Question</title>

<style>
.dropbtn {
	background-color: #6D7662;
	color: white;
	padding: 6px;
	font-size: 15px;
	border: none;
	cursor: pointer;
}

#myInput {
	border-box: box-sizing;
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd
}

.show {
	display: block;
}

div#box {
	margin-top: 15px;
}

div#box .box-top {
	color: #fff;
	text-shadow: 0 1px #000;
	background: #2980b9;
	padding: 5px;
	padding-left: 15px;
	font-weight: 300;
}

div#box .box-panel {
	padding: 15px;
	background: #fff;
	color: #333;
}
</style>
</head>
<body>
	<% List forumBean = (List)session.getAttribute("forumBean");
   request.setAttribute("forumBean",forumBean);
%>



	<form action="postQ" method="post" modelAttribute="postBean" id="postQ">
		Question : <input type="text" name="queryHeading" /><br>
		Question Description:
		<textarea rows="4" cols="50" name="queryDesc" form="postQ">
	</textarea>
		<br> Select Forum <br>
		<div class="dropdown">

			<select name="forumName">
				<c:forEach var="forum" items="${forumBean}">
					<option value="${forum.forumName}">${forum.forumName}</option>
				</c:forEach>
			</select> <input type="submit" /><br>
	</form>



	<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}
</script>

</body>
</html>