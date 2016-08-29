<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>calculate something</title>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>
	<body>
	    <div class="form-container">
		    <h1>Calculate BMI</h1>
		    <form:form method="POST" modelAttribute="bmi" class="form-horizontal">
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="weight">weight [kg]</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="weight" id="weight"/>
		                </div>
		            </div>
		        </div>
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="height">height [cm]</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="height" id="height"/>
		                </div>
		            </div>
		        </div>
		        
		        <div class="row">
		            <div class="form-actions">
		                <input type="submit" value="count" class="btn btn-primary btn-sm">
		            </div>
		        </div>
		    </form:form>
		   	<h1>Results</h1>	
			<table>
			    <tr>
			        <td>Weight:</td>
			        <td>${bmi.weight}</td>
			    </tr>
			    <tr>
			        <td>Height:</td>
			        <td>${bmi.height}</td>
			    </tr>
			    <tr>
			        <td>Result:</td>
			        <td>${result}</td>
			    </tr>
			</table>
		</div>
	</body>
</html>