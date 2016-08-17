<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<!-- <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />-->
</head>
<body>
	<div id="exTab1" class="container">	
		<ul  class="nav nav-pills">
			<li class="active">
	        	<a  href="#1a" data-toggle="tab">Overview</a>
			</li>
			<li>
				<a href="#2a" data-toggle="tab">Using nav-pills</a>
			</li>
			<li>
				<a href="#3a" data-toggle="tab">Applying clearfix</a>
			</li>
	  		<li>
	  			<a href="#4a" data-toggle="tab">Background color</a>
			</li>
		</ul>
	
		<div class="tab-content clearfix">
			<div class="tab-pane active" id="1a">
		        <h3>Content's background color is the same for the tab</h3>
		    </div>
			<div class="tab-pane" id="2a">
	    	    <h3>We use the class nav-pills instead of nav-tabs which automatically creates a background color for the tab</h3>
			</div>
	        <div class="tab-pane" id="3a">
				<h3>We applied clearfix to the tab-content to rid of the gap between the tab and the content</h3>
			</div>
	        <div class="tab-pane" id="4a">
	        	<h3>We use css to change the background color of the content to be equal to the tab</h3>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<a href="<c:url value="/ewelina" />"><h3>ccc</h3></a>
</body>

</html>