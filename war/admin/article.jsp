<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.plucial.inc.blog.base.DateUtils" %>
<%
List<ArticleModel> articleList = (List<ArticleModel>)request.getAttribute("articleList");
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
							<%for(ArticleModel articleModel: articleList) { %>
								<article class="box post" style="padding-bottom:0">
									<div class="row" style="margin-bottom:10px;font-size:0.8em;color:#5c5c5c;">
										<div>
											登録日：<%=DateUtils.dateToString(articleModel.getCreateDate(), "yyyy年MM月dd日") %>
										</div>
										<%
										CategoryModel categoryModel = articleModel.getArticleCategoryModel();
										if(categoryModel != null) { %>
										<div>カテゴリ：<a href="/admin/changeCategory?id=<%=articleModel.getKey().getId() %>"><%=categoryModel.getName() %></a></div>
										<%} %>
									</div>
									<p><%=articleModel.getTitle() %></p>
										
									<footer>
										<ul class="actions" style="text-align: center;">
											<li>
												<a href="/admin/articleUpdate?id=<%=articleModel.getKey().getId() %>" class="button">記事内容の更新</a>
											</li>
											<li>
												<a href="/admin/articleDelete?id=<%=articleModel.getKey().getId() %>" class="button" style="background: #5c5c5c;">記事の削除</a>
											</li>
										</ul>
									</footer>
								</article>
							<%} %>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/admin/common/main_footer.jsp" />

	</body>
</html>
