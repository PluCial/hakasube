<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%
CategoryModel categoryModel = (CategoryModel)request.getAttribute("categoryModel");
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
										<h2>カテゴリ「<%=categoryModel.getName() %>」を削除して本当によろしいですか？</h2>
										<p>このカテゴリを削除した後、削除したカテゴリ内の記事を他のカテゴリに移してください。</p>
									</header>
									
									<footer>
										<ul class="actions" style="text-align: center;">
											<li>	
												<a class="button" href="/admin/categoryDeleteEntry?id=<%=categoryModel.getKey().getId() %>" >削除</a>
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
