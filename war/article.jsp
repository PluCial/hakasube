<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="com.plucial.inc.blog.base.DateUtils" %>
<%@ page import="com.plucial.inc.blog.base.Utils" %>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%
ArticleModel articleModel = (ArticleModel)request.getAttribute("articleModel");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
		<style>
		<%=articleModel.getDocumentStyleSheetString() %>
		</style>
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<jsp:include page="/common/main_header.jsp" />
		
		<!-- Main -->
			<div id="main-wrapper">
			
				<jsp:include page="/common/change_lang_form.jsp" />
			
				<div class="container">
					<div class="row">
						<div class="8u important(collapse)">
							
							<!-- Content -->
								<article class="box post">
									
									<header>
										<div style="margin-bottom: 1em;color: #777;width: 100%;font-size:1.5em;">
											<span class="icon fa-clock-o" style="padding-right:5px"></span>
											<time datetime="<%=DateUtils.dateToString(articleModel.getCreateDate(), "yyyy-MM-dd") %>">
												<%=DateUtils.dateToString(articleModel.getCreateDate(), "yyyy.MM.dd") %>
											</time>
										</div>
										<h1 style="line-height: 1.5em;margin-bottom:1em;font-size: 1.6em;"><%=articleModel.getTitle() %></h1>
										
										<%
											CategoryModel categoryModel = articleModel.getCategoryModelRef().getModel();
											if(categoryModel != null) {
										%>
										<div style="display: inline-block;padding: 2px 10px;background-color: #e9575f;font-size: 12px;">
											<a href="/ac-<%=categoryModel.getKey().getId() %>" style="color:#fff"><span class="icon fa-bookmark-o" style="padding-right:5px"></span><%=categoryModel.getName() %></a>
										</div>
										<%} %>
										
									</header>
									
									<a href="#" class="image featured" style="margin-top:-2em">
										<img src="http://storage.googleapis.com/hakasube.appspot.com/eye-catch/<%=articleModel.getKey().getId() %>" />
									</a>
									
									<div id="article-content"><%=articleModel.getContentString() %></div>
									
									<%if(articleModel.getReferenceUrlString() != null && articleModel.getReferenceUrlString().length() > 0) { %>
									<footer>
										<ul class="actions" style="text-align: center;">
											<li>
												<a target="_blank" rel="nofollow" class="button" style="background: #5c5c5c;" href="<%=articleModel.getReferenceUrlString() %>">詳細はこちら</a>
											</li>
										</ul>
									</footer>
									<%} %>
								</article>

						</div>
						
						<!-- Sidebar -->
						<div class="4u">
<%-- 							<!-- Category -->
							<jsp:include page="/common/sidebar_category.jsp" /> --%>
							<!-- Category Article -->
							<jsp:include page="/common/sidebar_category_article.jsp" />
							<!-- Article -->
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
