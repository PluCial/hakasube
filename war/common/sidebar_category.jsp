<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="java.util.Date" %>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%
List<CategoryModel> categoryList = (List<CategoryModel>)request.getAttribute("categoryList");
%>
								<section class="box">
									<header>
										<h3>記事カテゴリ</h3>
									</header>
									<ul class="divided">
										<%for(CategoryModel categoryModel: categoryList) { %>
											<li>
												<span class="icon fa-angle-right" style="padding-right:5px;"></span>
												<a href="/ac-<%=categoryModel.getKey().getId() %>"><%=categoryModel.getName() %></a>
											</li>
										<%} %>
									</ul>
								</section>