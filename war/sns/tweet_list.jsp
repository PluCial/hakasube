<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@page import="com.plucial.inc.blog.base.DateUtils" %>
<%@ page import="java.util.List" %>
<%
List<SNSTwitModel> snsTwitList = (List<SNSTwitModel>)request.getAttribute("snsTwitList");
String twitterSearchKeyword = (String) request.getAttribute("twitterSearchKeyword");
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
						<div class="8u important(collapse)">
							
							<!-- Content -->
								<%for(SNSTwitModel twitModel: snsTwitList) { %>
								<article class="box post">
									<header>
										<h3 class="icon fa-twitter"><%=twitModel.getUserName() %></h3>
									</header>
									<p><%=twitModel.getContentString() %><</p>
								</article>
								<%} %>

						</div>
						
						<div class="4u">
							
							<!-- Category -->
							<jsp:include page="/common/sidebar_category.jsp" />
							
							<!-- article -->
							<jsp:include page="/common/sidebar_article.jsp" />
							
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
