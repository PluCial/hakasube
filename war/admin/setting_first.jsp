<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
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
						<div class="12u">
							
							<!-- Content -->
								<article class="box post">
									
									<form action="/admin/settingFirstEntry" enctype="multipart/form-data" method="post">
										<section>
											
											<h3 style="margin-top:3em">Googleプロジェクト名</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleApplicationName" ${f:text("googleApplicationName")} />
													<span class="err">${errors.googleApplicationName}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">GoogleクライアントID</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleProjectClientId" ${f:text("googleProjectClientId")} />
													<span class="err">${errors.googleProjectClientId}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Googleクライアントシークレット</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleProjectClientSecret" ${f:text("googleProjectClientSecret")} />
													<span class="err">${errors.googleProjectClientSecret}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">アプリケーション名(サイト名)</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="applecationName" ${f:text("applecationName")} />
													<span class="err">${errors.applecationName}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">管理ユーザーメールアドレス(Googleアカウント)</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="adminAccountEmail" ${f:text("adminAccountEmail")} />
													<span class="err">${errors.adminAccountEmail}</span>
												</div>
											</div>

										</section>
									
										<footer>
											<ul class="actions" style="text-align: center;">
												<li>
													<input type="submit" class="button icon fa-envelope" value="登録して次へ" />
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

