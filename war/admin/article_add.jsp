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
									
									<form action="/admin/articleEntry" enctype="multipart/form-data" method="post">
										<section>
											<h3>カテゴリの選択</h3>
											<p>記事に合うカテゴリを選択してください。</p>
											<div class="row uniform half">
												<div class="6u">
													<div class="select-wrapper">
														<select name="category" id="category">
															<option value="">- カテゴリ -</option>
																<%for(CategoryModel categoryModel: categoryList) { %>
																<option value="<%=categoryModel.getKey().getId() %>"><%=categoryModel.getName() %></option>
																<%} %>
														</select>
														<span class="err">${errors.category}</span>
													</div>
												</div>
											</div>
											
											<h3 style="margin-top:3em">GoogleドキュメントID入力</h3>
											<p>対象記事が書かれているGoogleドキュメントのIDを入力してください。</p>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="driveFileId" placeholder="Google Document Id" ${f:text("driveFileId")} />
													<span class="err">${errors.driveFileId}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">参照サイトURL</h3>
											<p>登録した記事のみ、記事下部に遷移ボタンが表示される。</p>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="referenceUrl" placeholder="http://xxxxx.xxx/" ${f:text("referenceUrl")} />
													<span class="err">${errors.referenceUrl}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">アイキャッチ画像の追加</h3>
											<p>対象記事が書かれているGoogleドキュメントのIDを入力してください。</p>
											<div class="row uniform half">
												<div class="12u">
													ファイル ： <input type="file" name="eyeCatch">
													<span class="err">${errors.eyeCatch}</span>
												</div>
											</div>
										</section>
									
										<footer>
											<ul class="actions" style="text-align: center;">
												<li>
													<input type="submit" class="button icon fa-envelope" value="記事を追加する" />
												</li>
											</ul>
										</footer>
									</form>
									
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/admin/common/main_footer.jsp" />

	</body>
</html>
