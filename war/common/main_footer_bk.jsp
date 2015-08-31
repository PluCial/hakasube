<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@ page import="java.util.List" %>
<%@ page import="com.plucial.inc.blog.base.Utils" %>
<%
String dateValue = new java.text.SimpleDateFormat( "yyyy", java.util.Locale.US).format(new Date());
List<CategoryModel> categoryList = (List<CategoryModel>)request.getAttribute("categoryList");
String projectApplecationName = (String) request.getAttribute("projectApplecationName");
String pageDescription = (String) request.getAttribute("pageDescription");
String socialTwitterUrl = (String) request.getAttribute("socialTwitterUrl");
String socialFacebookUrl = (String) request.getAttribute("socialFacebookUrl");
String socialGooglePlusUrl = (String) request.getAttribute("socialGooglePlusUrl");
List<ArticleModel> articletList = (List<ArticleModel>) request.getAttribute("newArticleList");
%>
		<!-- Footer -->
			<div id="footer-wrapper">
				<section id="footer" class="container" style="font-size: 14px;">
					
					<div class="row">
						<div class="4u">
							<section>
								<header>
									<h2>What's New</h2>
								</header>
								<ul class="divided">
									<%for(ArticleModel articleModel: articletList) { %>
									<li><a href="/article/<%=articleModel.getKey().getId() %>"><%=Utils.subContentsString(articleModel.getTitle(), 36) %></a></li>
									<%} %>
								</ul>
							</section>
						</div>
						<div class="4u">
							<section>
								<header>
									<h2>Blog Category</h2>
								</header>
								<ul class="divided">
									<%for(CategoryModel categoryModel: categoryList) { %>
										<li>
											<span class="icon fa-folder-open" style="padding-right:5px;"></span>
												<a href="/ac-<%=categoryModel.getKey().getId() %>"><%=categoryModel.getName() %></a>
										</li>
									<%} %>
								</ul>
							</section>
						</div>
						<div class="4u">
							<section>
								<header>
									<h2>ABOUT US</h2>
								</header>
								<ul class="divided">
									<li><span class="icon fa-hospital-o" style="padding-right:5px;"></span><a href="/info/<%=Constants.MAIN_MENU_SELECT_ABOUT %>">このサイトについて</a></li>
									<li><span class="icon fa-envelope" style="padding-right:5px;"></span><a href="/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>">お問い合わせ</a></li>
								</ul>
							</section>
							<section>
								<header>
									<h2>Social Media</h2>
									<p>提供している各サービスの最新情報を配信しています。</p>
									<p><a href="/sns/dateList">ソーシャルまとめ</a></p>
								</header>
								<ul class="social">
									<%if(socialGooglePlusUrl != null && socialGooglePlusUrl.length() > 0) { %>
									<li><a class="icon fa-google-plus" target="_blank" href="<%=socialGooglePlusUrl %>"><span class="label">Google+</span></a></li>
									<%} %>
									<%if(socialFacebookUrl != null && socialFacebookUrl.length() > 0) { %>
									<li><a class="icon fa-facebook" target="_blank" href="<%=socialFacebookUrl %>"><span class="label">Facebook</span></a></li>
									<%} %>
									<%if(socialTwitterUrl != null && socialTwitterUrl.length() > 0) { %>
									<li><a class="icon fa-twitter" target="_blank" href="<%=socialTwitterUrl %>"><span class="label">Twitter</span></a></li>
									<%} %>
								</ul>
							</section>
						</div>
					</div>
					<div class="row">
						<div class="12u">
						
							<!-- Copyright -->
								<div id="copyright">
									<ul class="links">
										<li>Copyright &copy; <a href="http://www.hakasube.com/">hakasube</a> <%=dateValue %>. All Rights Reserved.</li>
										<li>Power By: <a target="_blank" href="http://inc.plucial.com/">PluCial</a></li>
									</ul>
								</div>
						</div>
					</div>
				</section>
			</div>