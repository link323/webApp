<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <div class="container"/>
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
	<h2>List of results</h2>
	<div  class="tbl-header">
	<table cellpadding="0" cellspacing="0" border="0">
		<thead>	
			<tr>
				<td> pesel </td><td>	</td><td> result </td><td>	</td><td> date </td><td>	</td><td> before food </td><td>	</td><td> comment </td>
			</tr>
		</thead>
	</table>
	</div>
	<div  class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0">
  			<tbody>
				<c:forEach items="${diabeticResults}" var="result">
				<tr>
					<td>
			            <c:out value="${result.pesel}"/>
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${result.result}" />
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${result.date}"/>
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${result.beforeFood}" />
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${result.comment}" />
			        </td>
				</tr>
				</c:forEach>
		 	</tbody>
		</table>
	</div>	
	
	<h2>List of pressure results</h2>
	<div  class="tbl-header">
	<table cellpadding="0" cellspacing="0" border="0">
		<thead>	
			<tr>
				<td> pesel </td><td>	</td><td> systolic </td><td>	</td><td> diastolic </td><td>	</td><td> date </td><td>	</td><td> comment </td>
			</tr>
		</thead>
	</table>
	</div>
	<div  class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0">
  			<tbody>
				<c:forEach items="${pressureResults}" var="pressureResult">
				<tr>
					<td>
			            <c:out value="${pressureResult.pesel}"/>
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${pressureResult.systolic}" />
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${pressureResult.diastolic}"/>
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${pressureResult.date}" />
			        </td>
			        <td>	</td>
			        <td>
			            <c:out value="${pressureResult.comment}" />
			        </td>
				</tr>
				</c:forEach>
		 	</tbody>
		</table>
	</div>
</body>
</html>