<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="com.plucial.inc.blog.base.model.*" %>
<%
CategoryModel categoryModel = (CategoryModel)request.getAttribute("categoryModel");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<jsp:include page="/common/main_header.jsp" />
		
		<!-- Main -->
			<div id="main-wrapper">
			
				<div class="container">
					<div class="row">
						<div class="12u">
							
							<section>
								<header class="major">
									<h2><%=categoryModel.getName() %></h2>
								</header>
								<div class="row">						
									<jsp:include page="/common/article_list.jsp" />
								</div>
									
							</section>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/common/main_footer.jsp" />
			
		<!-- Analytics JavaScript -->
			<jsp:include page="/common/analytics_script.jsp" />

	</body>
</html>
