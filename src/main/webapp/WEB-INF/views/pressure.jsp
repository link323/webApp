<%@page import="com.websystique.springsecurity.model.PressureResults"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<div id="exTab1" class="container">	
		<ul  class="nav nav-pills">
		    <h1><a href="#"><span>MedApp</span></a></h1>
			<li class="home selected"><a class="active" href="<c:url value='/home' />"><span>Home</span></a></li>
			<li class="diabetic"><a href="<c:url value='/diabetic' />"><span>diabetic</span></a></li>
			<li class="blood pressure"><a href="<c:url value='/pressure' />"><span>pressure</span></a></li>
			<li class="contact"><a href="#"><span>Contact</span></a></li>
		</ul>
	</div>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="made-with-love">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<label for="pacient">Pacjent: </label>
	<select id="pacjent">
		<c:forEach items="${pressureResults}" var="pressureResult">
			<option value="${pressureResult.systolic}">${pressureResult.systolic}</option>
		</c:forEach>
		<input type="submit" value="Submit">
	</select>
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
          var data = google.visualization.arrayToDataTable([
            ['date', 'pressure'],
            ['2004',  1000],
            ['2005',  1170],
            ['2006',  660],
            ['2007',  1030]
          ]);

          var options = {
            title: request.getParameter("item"),
            curveType: 'function',
            legend: { position: 'bottom' }
          };

          var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

          chart.draw(data, options);
        }
    </script>
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
	
	<h2>List of pressure request.getParameter("item")</h2>
	<div  class="tbl-header">
	<table cellpadding="0" cellspacing="0" border="0">
		<thead>	
			<tr>
				<td> pesel </td><td>	</td><td> systolic </td><td>	</td><td> diastolic </td><td>	</td><td> date </td><td>	</td><td> comment </td>
			</tr>
		</thead>
	</table>
	<div  class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0">
  			<tbody>
				<c:forEach items="${pressureResults}" var="pressureResult">
				<tr>
					<c:choose>
	    				<c:when test="${pressureResult.pesel == 90051778909}">
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
				        </c:when>
			        </c:choose>
				</tr>
				</c:forEach>
		 </tbody>
	</table>
	<div class="made-with-love">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>

</html>