<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="com.plucial.inc.blog.base.model.*" %>
<?xml version="1.0" encoding="UTF-8"?>
<%
String applicationDomain = (String) request.getAttribute("applicationDomain");
List<CategoryModel> caetgoryList = (List<CategoryModel>) request.getAttribute("caetgoryList");
List<SNSDateModel> snsDateList = (List<SNSDateModel>) request.getAttribute("snsDateList");
%>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
	<url>
		<loc>http://<%=applicationDomain %>/</loc>
		<changefreq>daily</changefreq>
		<priority>1.0</priority>
	</url>
	<url>
		<loc>http://<%=applicationDomain %>/info/about</loc>
		<changefreq>daily</changefreq>
		<priority>0.5</priority>
	</url>
	<url>
		<loc>http://<%=applicationDomain %>/info/contact</loc>
		<changefreq>daily</changefreq>
		<priority>0.5</priority>
	</url>
	<%
 	for(CategoryModel categoryModel: caetgoryList) {
	%>
	<url>
		<loc>http://<%=applicationDomain %>/ac-<%=categoryModel.getKey().getId() %></loc>
		<changefreq>daily</changefreq>
		<priority>0.5</priority>
	</url>
		<%
		List<ArticleModel> articleList = categoryModel.getArticleModelListRef().getModelList();
		if(articleList != null) {
			for(ArticleModel articleModel: articleList) {
		%>
	<url>
		<loc>http://<%=applicationDomain %>/article/<%=articleModel.getKey().getId() %></loc>
		<changefreq>daily</changefreq>
		<priority>0.5</priority>
	</url>
		<%	} %>
		<%} %>
	<%} %>
	
	<url>
		<loc>http://<%=applicationDomain %>/sns/dateList</loc>
		<changefreq>daily</changefreq>
		<priority>0.3</priority>
	</url>
	<%
 	for(SNSDateModel snsDateModel: snsDateList) {
	%>
	<url>
		<loc>http://<%=applicationDomain %>/sns/tweets-<%=snsDateModel.getKey().getName() %></loc>
		<changefreq>daily</changefreq>
		<priority>0.3</priority>
	</url>
	<%} %>
</urlset>
