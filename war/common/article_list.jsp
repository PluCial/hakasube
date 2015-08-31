<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@ page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="com.plucial.inc.blog.base.DateUtils" %>
<%@ page import="com.plucial.inc.blog.base.Utils" %>
<%
List<ArticleModel> articletList = (List<ArticleModel>) request.getAttribute("articletList");
%>
										<%for(ArticleModel articleModel: articletList) { %>
										<div class="4u">
											<section class="box" style="position: relative;">
												<a href="/article/<%=articleModel.getKey().getId() %>" class="image featured" style="display: block;overflow: hidden;max-height: 200px;">
													<img src="http://storage.googleapis.com/hakasube.appspot.com/eye-catch/<%=articleModel.getKey().getId() %>" style="width:100%;" />
												</a>
												<%
												CategoryModel categoryModel = articleModel.getArticleCategoryModel();
												if(categoryModel != null) {
												%>
												<div style="position: absolute;top: 5px;left: 0px;padding: 2px 10px;background-color: #e9575f;font-size: 12px;">
													<a href="/ac-<%=categoryModel.getKey().getId() %>" style="color:#fff"><span class="icon fa-bookmark-o" style="padding-right:5px"></span><%=categoryModel.getName() %></a>
												</div>
												<%} %>
												<header>
													<p style="font-size: 0.8em;color: #555;"><span class="icon fa-clock-o" style="padding-right:5px"></span><%=DateUtils.dateToString(articleModel.getCreateDate(), "yyyy.MM.dd") %></p>
													<h3><a href="/article/<%=articleModel.getKey().getId() %>"><%=Utils.subContentsString(articleModel.getTitle(), 36) %></a></h3>
												</header>
											</section>
										</div>
										<%} %>