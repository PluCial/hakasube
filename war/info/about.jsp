<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.plucial.inc.blog.base.Constants" %>
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
								<article class="box post">
									<!-- <a href="#" class="image featured"><img src="/images/about3.jpg" alt="" /></a> -->
									<header>
										<h2>このサイトについて</h2>
									</header>
									<p>当サイトでは、Googleによるアクセス解析ツール「Googleアナリティクス」を利用しています。 このGoogleアナリティクスはトラフィックデータの収集のためにCookieを使用しています。 このトラフィックデータは匿名で収集されており、個人を特定するものではありません。 この機能はCookieを無効にすることで収集を拒否することが出来ますので、お使いのブラウザの設定をご確認ください。 この規約に関して、詳しくはここをご参照ください。</p>
									
								</article>

						</div>
						
						<div class="4u">
							
							<!-- Category -->
<%-- 							<jsp:include page="/common/sidebar_category.jsp" /> --%>
							
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
