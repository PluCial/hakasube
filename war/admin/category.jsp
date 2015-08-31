<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%
List<CategoryModel> categoryList = (List<CategoryModel>)request.getAttribute("categoryList");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/admin/common/html_head.jsp" />
		<style type="text/css"><!--
			form span.err {
				color: red;
			}
		//--></style>
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
										<h2>カテゴリの追加</h2>
									</header>
									
									<form action="/admin/categoryEntry" method="post">
										<section>
											<h3 style="margin-top:3em">カテゴリ名入力</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="categoryName" placeholder="カテゴリ名" ${f:text("categoryName")} />
													<span class="err">${errors.categoryName}</span>
												</div>
											</div>
										</section>
									
										<footer>
											<ul class="actions" style="text-align: center;">
												<li>
													<input type="submit" class="button icon fa-envelope" value="カテゴリを追加する" /></li>
											</ul>
										</footer>
									</form>
									
								</article>
								
								<article class="box post">
									<header>
										<h2>現在のカテゴリ一覧</h2>
									</header>
									
									<hr />
									
									<%for(CategoryModel categoryModel: categoryList) { %>
										
										<form action="/admin/categoryEditEntry" method="post" class="row">
											<div class="6u">
												<input type="text" name="categoryName" placeholder="カテゴリ名" value="<%=categoryModel.getName() %>" />
											</div>
											<div class="2u">
												<input type="text" name="categoryIndex" value="<%=categoryModel.getIndex() %>" />
											</div>
											<div class="2u">
												<input type="submit" class="button" value="変更" />
											</div>
											<div class="2u"><a href="/admin/categoryDelete?id=<%=categoryModel.getKey().getId() %>" class="">削除</a></div>
											<input type="hidden" name="categoryId" value="<%=categoryModel.getKey().getId() %>">
										</form>
										<hr />
									<%} %>
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/admin/common/main_footer.jsp" />

	</body>
</html>
