<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
String twitterAccessToken = (String) request.getAttribute("twitterAccessToken");
String twitterTokenSecret = (String) request.getAttribute("twitterTokenSecret");
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
									
									<form action="/admin/settingEntry" enctype="multipart/form-data" method="post">
										<section>
										
											<h2>基本設定</h2>
											<hr/>
											
											<h3 style="margin-top:3em">アプリのドメイン<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="applicationDomain" ${f:text("applicationDomain")} />
													<span class="err">${errors.applicationDomain}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Googleプロジェクト名<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleApplicationName" ${f:text("googleApplicationName")} />
													<span class="err">${errors.googleApplicationName}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">GoogleクライアントID<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleProjectClientId" ${f:text("googleProjectClientId")} />
													<span class="err">${errors.googleProjectClientId}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Googleクライアントシークレット<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="googleProjectClientSecret" ${f:text("googleProjectClientSecret")} />
													<span class="err">${errors.googleProjectClientSecret}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">アプリケーション名(サイト名)<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="applecationName" ${f:text("applecationName")} />
													<span class="err">${errors.applecationName}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">管理ユーザーメールアドレス(Googleアカウント)<span style="color:red">(必須)</span></h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="adminAccountEmail" ${f:text("adminAccountEmail")} />
													<span class="err">${errors.adminAccountEmail}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">サイトのDescription</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="projectDescription" ${f:text("projectDescription")} />
													<span class="err">${errors.projectDescription}</span>
												</div>
											</div>
											
											<br /><br /><br />
											<h2>Twitter自動収集のための設定</h2>
											<hr/>
											<h3 style="margin-top:3em">Twitter(アプリケーションキー)</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="twitterAppApiKey" ${f:text("twitterAppApiKey")} />
													<span class="err">${errors.twitterAppApiKey}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Twitter(アプリケーションシークレット)</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="twitterAppApiSecret" ${f:text("twitterAppApiSecret")} />
													<span class="err">${errors.twitterAppApiSecret}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Twitter(検索キーワード)</h3>
											<p>複合キーワードの場合は半角スペースで区切ってください。</p>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="twitterSearchKeyword" ${f:text("twitterSearchKeyword")} />
													<span class="err">${errors.twitterSearchKeyword}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Twitter アプリケーション承認</h3>
											<div class="row uniform half">
												<div class="12u">
													<p style="padding-top:15px">
														<a href="/admin/twitter/oAuth" >
															<img width="150px" src="/admin/images/twitter-login-button.png" />
														</a>
													</p>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Twitter Access Token</h3>
											<div class="row uniform half">
												<div class="12u">
													<p><%=twitterAccessToken %></p>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Twitter Token Secret</h3>
											<div class="row uniform half">
												<div class="12u">
													<p><%=twitterTokenSecret %></p>
												</div>
											</div>
											
											
											<br /><br /><br />
											<h2>Google Analyticsの設定</h2>
											<hr/>
											<h3 style="margin-top:3em">Google Analytics トラキングID</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="analyticsId" ${f:text("analyticsId")} />
													<span class="err">${errors.analyticsId}</span>
												</div>
											</div>
											
											<br /><br /><br />
											<h2>ソーシャルメディアの設定</h2>
											<hr/>
											<h3 style="margin-top:3em">Twitter Url</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="socialTwitterUrl" ${f:text("socialTwitterUrl")} />
													<span class="err">${errors.socialTwitterUrl}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Facebook Url</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="socialFacebookUrl" ${f:text("socialFacebookUrl")} />
													<span class="err">${errors.socialFacebookUrl}</span>
												</div>
											</div>
											
											<h3 style="margin-top:3em">Google+ Url</h3>
											<div class="row uniform half">
												<div class="12u">
													<input type="text" name="socialGooglePlusUrl" ${f:text("socialGooglePlusUrl")} />
													<span class="err">${errors.socialGooglePlusUrl}</span>
												</div>
											</div>

										</section>
									
										<footer>
											<ul class="actions" style="text-align: center;">
												<li>
													<input type="submit" class="button icon fa-envelope" value="変更を保存" />
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

