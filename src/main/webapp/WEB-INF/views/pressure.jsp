<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
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
		<div id="exTab1" class="container">	
			<ul  class="nav nav-pills">
			    <h1><a href="#"><span>MedApp</span></a></h1>
				<li class="home selected"><a class="active" href="<c:url value='/home' />"><span>Home</span></a></li>
				<li class="diabetic"><a href="<c:url value='/diabetic' />"><span>diabetic</span></a></li>
				<li class="blood pressure"><a href="<c:url value='/pressure' />"><span>pressure</span></a></li>
				<li class="calculators"><a href="<c:url value='/calculators' />"><span>calculators</span></a></li>
			</ul>
		</div>
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
		<div>
			<h1>calculated statistics</h1>	
			<table>
			    <tr>
			        <td>Maximum:</td>
			        <td>${max}</td>
			    </tr>
			    <tr>
			        <td>Minimum:</td>
			        <td>${min}</td>
			    </tr>
			    <tr>
			        <td>Median:</td>
			        <td>${median}</td>
			    </tr>
			    <tr>
			        <td>Mean:</td>
			        <td>${mean}</td>
			    </tr>
			</table>
		</div>

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

	<!--  added by doge -->
	<%
		int i = 0;
	%>
	<c:forEach items="${pressureResults}" var="pressureResult">
		<input type="hidden" value="${pressureResult.systolic}" id=<%= "systolic_"+i %>>
		<input type="hidden" value="${pressureResult.diastolic}" id=<%= "diastolic_"+i++ %>>
	</c:forEach>
	
	<input type="hidden" value="${pressureResults.size()}" id="numberOfResults">
	
	<!--   end added by doge  -->

</body>
</html>