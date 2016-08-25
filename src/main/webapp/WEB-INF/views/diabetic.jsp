<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
	<div>
			<h1>Type pacient's PESEL</h1>
		    <form:form method="POST" modelAttribute="chosenPacient" class="form-horizontal">
		    	<h2>total</h2>
		        <div class="row">
		            <div class="form-group col-md-12">
		                <label class="col-md-3 control-lable" for="total">PESEL</label>
		                <div class="col-md-7">
		                    <form:input type="number" step="any" path="pesel" id="pesel" required = "true"/>
		                </div>
		            </div>
		        </div>
		

				<div class="row">
		            <div class="form-actions floatRight">
		                <input type="submit" value="count" class="btn btn-primary btn-sm">
		            </div>
		        </div>
		    </form:form>
	</div>
<!-- 	<div>
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
	</div>-->
	
	<h2>List of glucose results</h2>
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
	</body>

</html>