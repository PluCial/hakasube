<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
String oauthUrl = (String) request.getAttribute("oauthUrl");
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
						<div class="12u">
							
							<!-- Content -->
								<article class="box post" style="text-align: center;">
									<!-- <a href="#" class="image featured"><img src="/images/about3.jpg" alt="" /></a> -->
									<header>
										<h2>ログイン</h2>
									</header>
									
									<div>
										<a href="<%=oauthUrl %>" class="g-signin"><img alt="Sign in Google" src="/admin/images/google-sign-in-button.png" style="width: 200px;" /></a>
									</div>
									
								</article>

						</div>
					</div>
				</div>
			</div>

		<!-- Footer -->
			<jsp:include page="/admin/common/main_footer.jsp" />

	</body>
</html>

