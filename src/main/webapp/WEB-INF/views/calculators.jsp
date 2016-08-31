<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<%@ include file="header.html" %>
	<body>
	 	<%@ include file="tabs.html" %>
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