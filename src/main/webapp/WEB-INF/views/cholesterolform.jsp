<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Check cholesterol</title>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>
	<body>
		<div class="form-container">
			<h1>Check cholesterol value</h1>
		    <form:form method="POST" modelAttribute="cholesterol" class="form-horizontal">
		    	<h2>total</h2>
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="total">cholesterol [mg/dl]</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="total" id="total" required = "true"/>
		                </div>
		            </div>
		        </div>
		
		    	<h2>HDL</h2>
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="hdl">cholesterol [mg/dl]</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="hdl" id="hdl" required = "true"/>
		                </div>
		            </div>
		        </div>
		
		    	<h2>LDL</h2>
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="ldl">cholesterol [mg/dl]</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="ldl" id="ldl" required = "true"/>
		                </div>
		            </div>
		        </div>
				<div class="row">
		            <div class="form-actions floatRight">
		                <input type="submit" value="count" class="btn btn-primary btn-sm">
		            </div>
		        </div>
		    </form:form>
		    <h1>Results</h1>	
			<table>
			    <tr>
			        <td>Total:</td>
			        <td>${total}</td>
			    </tr>
			    <tr>
			        <td>LDL:</td>
			        <td>${ldl}</td>
			    </tr>
			    <tr>
			        <td>HDL:</td>
			        <td>${hdl}</td>
			    </tr>
			</table>
		</div>
	</body>
</html>