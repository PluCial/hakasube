<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%
String projectApplecationName = (String) request.getAttribute("projectApplecationName");
%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
	</head>
	<body class="homepage">

		<!-- Header -->
			<div id="header-wrapper">
				<div id="header">
					
					<!-- Logo -->
						<!-- <h1><a href="/"><span style="font-size: 0.5em;">株式会社</span> <span style="color:#dd4b39">P</span>lu<span style="color:#dd4b39">C</span>ial</a></h1> -->
						<h1>
							<a href="/"><span style="font-size: 0.5em;margin-right:10px;display: none;"><%=projectApplecationName %></span><img alt="hakasube" src="http://storage.googleapis.com/hakasube.appspot.com/images/logo.png"></a>
						</h1>
					
					<!-- Nav -->
						<jsp:include page="/common/main_header_nav.jsp" />
						
						<!-- <section id="banner">
							<header>
								<h2>広告キャッチコピー</h2>
								<p>広告詳細文言</p>
							</header>
						</section> -->
		
				</div>
			</div>

		<!-- Main -->
			<div id="main-wrapper">
				<div class="container">
				
					<div class="row">
						<div class="12u">
								<section>
									<header class="major">
										<h2>新着記事</h2>
									</header>
									<div class="row">
 										<jsp:include page="/common/article_list.jsp" />
									</div>
								</section>
						</div>
					</div>
				
					<%-- <div class="row">
						<div class="12u">

							<!-- サービス -->
								<section>
									<header class="major">
										<h2>ピックアップ記事</h2>
									</header>
									<div class="row">
										<div class="6u">
											<section class="box">
												<a href="#" class="image featured"><img src="/images/pic08.jpg" alt="" /></a>
												<header>
													<h3>超高級墓石をご紹介</h3>
													<!-- <p>ここは自分が書いた文章でもいいから、なにかしらテキストが打てるといいな♡ここは後々広告用にしたい</p> -->
												</header>
												<p style="color: #777;font-size: 0.8em;">ここは自分が書いた文章でもいいから、なにかしらテキストが打てるといいな♡ここは後々広告用にしたい</p>
												<footer>
													<ul class="actions" style="text-align: right;">
														<li><a href="#" class="button icon fa-external-link" target="_blank">詳しくはこちら</a></li>
													</ul>
												</footer>
											</section>
										</div>
										<div class="6u">
											<section class="box">
												<a href="#" class="image featured"><img src="/images/pic09.jpg" alt="" /></a>
												<header>
													<h3>こんなところで眠りたい・・・</h3>
<!-- 													<p>これでもアクセスが増えなかったらもう諦めよう</p> -->
												</header>
												<p style="color: #777;font-size: 0.8em;">ここは自分が書いた文章でもいいから、なにかしらテキストが打てるといいな♡ここは後々広告用にしたい</p>
												<footer>
													<ul class="actions" style="text-align: right;">
														<li><a href="#" class="button icon fa-external-link" target="_blank">詳しくはこちら</a></li>
													</ul>
												</footer>
											</section>
										</div>
									</div>
								</section>
							
						</div>
					</div> --%>

				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/common/main_footer.jsp" />
			
		<!-- Analytics JavaScript -->
			<jsp:include page="/common/analytics_script.jsp" />

	</body>
</html>
