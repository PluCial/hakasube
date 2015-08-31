<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="/common/html_head.jsp" />
		<style type="text/css"><!--
			form span.err {
				color: red;
			}
		//--></style>
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
								<article class="box post">
									<!-- <a href="#" class="image featured"><img src="/images/thank-you.jpg" alt="" /></a> -->
									<header>
										<h2>お問い合わせ頂きありがとうございました。</h2>
										<p>できる限り早く返信できるように致しますので、今しばらくお待ちください。</p>
									</header>
									
									<footer>
										<ul class="actions" style="text-align: center;">
											<li><a href="/" class="button icon fa-external-link">サイトトップへ</a></li>
										</ul>
									</footer>

								</article>

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

	</body>
</html>
