<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.html" %>

<html>
	<head>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript"
			src="/SpringSecurityHibernateAnnotationExample/static/js/chart.js"></script>
		<script type="text/javascript">
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});
			drawChart('glucose', "result_", "curve_chart");
		</script>
	</head>
	<body>
		<%@ include file="tabs.html" %>
		<%@ include file="peselinput.html" %>	
		<%@ include file="statistictable.html" %>
		
		<div id="curve_chart" style="width: 900px; height: 500px"></div>
		
		<h2>List of glucose results</h2>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<td>pesel</td>
						<td></td>
						<td>result</td>
						<td></td>
						<td>date</td>
						<td></td>
						<td>before food</td>
						<td></td>
						<td>comment</td>
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<c:forEach items="${diabeticResults}" var="result">
						<tr>
							<td><c:out value="${result.pesel}" /></td>
							<td></td>
							<td><c:out value="${result.result}" /></td>
							<td></td>
							<td><c:out value="${result.date}" /></td>
							<td></td>
							<td><c:out value="${result.beforeFood}" /></td>
							<td></td>
							<td><c:out value="${result.comment}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%
			int i = 0;
		%>
		<c:forEach items="${diabeticResults}" var="result">
			<input type="hidden" value="${result.result}" id=<%= "result_"+i++ %>>
		</c:forEach>
		<input type="hidden" value="${diabeticResults.size()}"
			id="numberOfResults">
	
	</body>
</html>