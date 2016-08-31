<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.html" %>
<html>
	<head>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript" src="/SpringSecurityHibernateAnnotationExample/static/js/chart.js"></script>
		<script type="text/javascript">
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});
			drawChart('blood pressure - systolic part', ["systolic_"], "curve_chart_systolic");
			drawChart('blood pressure - diastolic part', ["diastolic_"], "curve_chart_diastolic");
		</script>
	</head>
	<body>
		<%@ include file="tabs.html" %>
		<%@ include file="peselinput.html" %>
	
		<h1>${message}</h1>
		<%@ include file="statistictable.html" %>

		<div id="curve_chart_systolic" style="width: 900px; height: 500px"></div>
    	<div id="curve_chart_diastolic" style="width: 900px; height: 500px"></div>
    
		<h1>List of pressure results</h1>
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
		<%
			int i = 0;
		%>
		<c:forEach items="${pressureResults}" var="pressureResult">
			<input type="hidden" value="${pressureResult.systolic}" id=<%= "systolic_"+i %>>
			<input type="hidden" value="${pressureResult.diastolic}" id=<%= "diastolic_"+i++ %>>
		</c:forEach>
		
		<input type="hidden" value="${pressureResults.size()}" id="numberOfResults">
		
	</body>
</html>