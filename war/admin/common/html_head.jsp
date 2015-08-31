<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%
String projectApplecationName = (String) request.getAttribute("projectApplecationName");
String pageDescription = (String) request.getAttribute("pageDescription");

String pageTitle = (String) request.getAttribute("pageTitle");
%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><%=pageTitle == null ? "" : pageTitle %> | <%=projectApplecationName == null ? "" : projectApplecationName %></title>
	<link rel="icon" type="image/png" href="/favicon.png" >

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="<%=pageDescription == null ? "" : pageDescription %>" />
	<meta name="keywords" content="" />
	
	<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
	<script src="/admin/js/jquery.min.js"></script>
	<script src="/admin/js/jquery.dropotron.min.js"></script>
	<script src="/admin/js/skel.min.js"></script>
	<script src="/admin/js/skel-layers.min.js"></script>
	<script src="/admin/js/init.js"></script>
	<noscript>
		<link rel="stylesheet" href="/admin/css/skel.css" />
		<link rel="stylesheet" href="/admin/css/style.css" />
		<link rel="stylesheet" href="/admin/css/style-desktop.css" />
	</noscript>
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	
	
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