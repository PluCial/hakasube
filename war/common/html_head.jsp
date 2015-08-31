<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%
String projectApplecationName = (String) request.getAttribute("projectApplecationName");
String pageDescription = (String) request.getAttribute("pageDescription");

String pageTitle = (String) request.getAttribute("pageTitle");
%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><%=pageTitle == null ? "" : pageTitle + " | " %><%=projectApplecationName == null ? "" : projectApplecationName %></title>
	<link rel="icon" type="image/png" href="/favicon.png" >

	<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
	<script src="http://storage.googleapis.com/hakasube.appspot.com/js/jquery.min.js"></script>
	<script src="http://storage.googleapis.com/hakasube.appspot.com/js/jquery.dropotron.min.js"></script>
	<script src="http://storage.googleapis.com/hakasube.appspot.com/js/skel.min.js"></script>
	<script src="http://storage.googleapis.com/hakasube.appspot.com/js/skel-layers.min.js"></script>
	<script src="http://storage.googleapis.com/hakasube.appspot.com/js/init.js"></script>
	<noscript>
		<link rel="stylesheet" href="http://storage.googleapis.com/hakasube.appspot.com/css/skel.css" />
		<link rel="stylesheet" href="http://storage.googleapis.com/hakasube.appspot.com/css/style.css" />
		<link rel="stylesheet" href="http://storage.googleapis.com/hakasube.appspot.com/css/style-desktop.css" />
	</noscript>
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	
	<!-- castom css -->
	<link rel="stylesheet" href="http://storage.googleapis.com/hakasube.appspot.com/css/custom.css" />
	
	

	<!-- SP -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum=1, minimal-ui">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- /SP -->

	<!-- OGP -->
	<meta property="og:title" content="<%=pageTitle == null ? "" : pageTitle %> | <%=projectApplecationName == null ? "" : projectApplecationName %>" />
	<meta property="og:type" content="article" />
	<meta property="og:site_name" content="<%=projectApplecationName == null ? "" : projectApplecationName %>">
	<meta property="og:description" content="<%=pageDescription == null ? "" : pageDescription %>">
	<!-- /OGP -->