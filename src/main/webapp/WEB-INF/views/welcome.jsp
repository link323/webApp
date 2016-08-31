<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.html" %>

<html>
	<body>
		<%@ include file="tabs.html" %>
		
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