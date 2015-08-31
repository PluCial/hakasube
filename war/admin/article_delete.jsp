<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%
ArticleModel articleModel = (ArticleModel)request.getAttribute("articleModel");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/admin/common/html_head.jsp" />
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<jsp:include page="/admin/common/main_header.jsp" />
		
		<!-- Main -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="4u">
						
							<!-- Sidebar -->
								<jsp:include page="/admin/common/sidebar_admin.jsp" />

						</div>
						
						<div class="8u important(collapse)">
							
							<!-- Content -->
								<article class="box post">
									<header>
										<h2><%=articleModel.getTitle() %></h2>
										<p>を削除して本当によろしいですか？</p>
									</header>
									
									<footer>
										<ul class="actions" style="text-align: center;">
											<li>	
												<a class="button" href="/admin/articleDeleteEntry?id=<%=articleModel.getKey().getId() %>" >削除</a>
											</li>
										</ul>
									</footer>
									
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/admin/common/main_footer.jsp" />

	</body>
</html>
