<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.plucial.inc.blog.base.Utils" %>
<%
List<ArticleModel> articletList = (List<ArticleModel>) request.getAttribute("categoryArticleList");
CategoryModel categoryModel = (CategoryModel)request.getAttribute("categoryModel");
%>
								<section class="box" id="sidebar_category_article">
									<header>
										<h3>関連記事</h3>
									</header>
									<ul class="divided">
										<%for(ArticleModel articleModel: articletList) { %>
										<li style="line-height: 1.5em;font-size: 14px;">
											<span style="display: block;overflow: hidden;max-height: 120px;margin-bottom: 10px;">
												<a href="/article/<%=articleModel.getKey().getId() %>">
													<img style="width:100%;" src="http://storage.googleapis.com/hakasube.appspot.com/eye-catch/<%=articleModel.getKey().getId() %>" />
												</a>
											</span>
											<a href="/article/<%=articleModel.getKey().getId() %>">
												<%=Utils.subContentsString(articleModel.getTitle(), 36) %>
											</a>
										</li>
										<%} %>
									</ul>
									<footer>
										<ul class="actions" style="text-align: center;margin-bottom:0;">
											<li>
												<a class="button" href="/ac-<%=categoryModel.getKey().getId() %>">さらにみる</a>
											</li>
										</ul>
									</footer>
								</section>