<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <div class="container"><h1>Bootstrap  tab panel example (using nav-pills)  </h1></div>
		<div id="exTab1" class="container">	
			<ul  class="nav nav-pills">
		    	<h1><a href="#"><span>MedApp</span></a></h1>
			      <li class="home selected"><a class="active" href="<c:url value='/home' />"><span>Home</span></a></li>
			      <li class="diabetic"><a href="<c:url value='/diabetic' />"><span>diabetic</span></a></li>
			      <li class="blood pressure"><a href="<c:url value='/pressure' />"><span>pressure</span></a></li>
			      <li class="calculators"><a href="<c:url value='/calculators' />"><span>calculators</span></a></li>
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
		<c:forEach items="${pacients}" var="pacients">
			<option value="${pacients.pesel}">${pacients.pesel}</option>
		</c:forEach>
		<input type="submit" value="Submit">
	</select>
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['date', 'result'],
          ['2004',  1000],
          ['2005',  1170],
          ['2006',  660],
          ['2007',  1030]     
        ]);

        var options = {
          title: 'glucose',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
	
	<h2>List of glucose results</h2>
	<div  class="tbl-header">
		<table cellpadding="0" cellspacing="0" border="0">
			<thead>	
				<tr>
					<td> pesel </td><td>	</td><td> result </td><td>	</td><td> date </td><td>	</td><td> before food </td><td>	</td><td> comment </td>
				</tr>
			</thead>
		</table>
		<div  class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
	  			<tbody>
					<c:forEach items="${diabeticResults}" var="result">
						<c:choose>
	    					<c:when test="${result.pesel == 90032518908}">
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
							</c:when>
						</c:choose>	
					</c:forEach>
			 	</tbody>
			</table>
		</div>
	</div>	
</body>

</html>