<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
		<div id="exTab1" class="container">	
			<ul  class="nav nav-pills">
		    	<h1><a href="#"><span>MedApp</span></a></h1>
			      <li class="home selected"><a class="active" href="<c:url value='/home' />"><span>pacients in risk</span></a></li>
			      <li class="diabetic"><a href="<c:url value='/diabetic' />"><span>diabetic</span></a></li>
			      <li class="blood pressure"><a href="<c:url value='/pressure' />"><span>pressure</span></a></li>
			      <li class="calculators"><a href="<c:url value='/calculators' />"><span>calculators</span></a></li>
		    </ul>
		</div>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>
	<body>
	 
	    <div class="form-container">
	    	<div class="form-actions floatRight">
				<form action="<c:url value='/bmiform' />">
	    			<input type="submit" value="Count BMI" class="btn btn-primary btn-sm"/>
				</form>
				<form action="<c:url value='/cholesterolform' />">
	    			<input type="submit" value="Check what cholesterol value means" class="btn btn-primary btn-sm"/>
				</form>
			</div>
		</div>
	</body>
</html>