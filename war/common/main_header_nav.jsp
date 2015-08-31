<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="com.plucial.inc.blog.base.Constants" %>
<%@page import="com.plucial.inc.blog.base.model.*" %>
<%@ page import="java.util.List" %>
<%
String mainMenuSelect = (String) request.getAttribute("mainMenuSelect");
List<CategoryModel> categoryList = (List<CategoryModel>)request.getAttribute("categoryList");
%>
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<%-- <li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_HOME) ? "current" : "" %>" style="white-space: nowrap;"><a href="/"><span class="icon fa-home" style="padding-right:5px;"></span>Home</a></li> --%>
								<li class="opener" style="-webkit-user-select: none; cursor: pointer; white-space: nowrap; opacity: 1;">
									<a href=""><span class="icon fa-bars" style="padding-right:5px;"></span>menu</a>
									
									<ul class="" style="-webkit-user-select: none; display: none; position: absolute;">
										<%for(CategoryModel categoryModel: categoryList) { %>
											<li style="white-space: nowrap;"><a href="/ac-<%=categoryModel.getKey().getId() %>" style="display: block;"><span class="icon fa-angle-right" style="padding-right:5px;"></span><%=categoryModel.getName() %></a></li>
										<%} %>
									</ul>
								</li>
								<%-- <li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_ABOUT) ? "current" : "" %>" style="white-space: nowrap;"><a href="/info/<%=Constants.MAIN_MENU_SELECT_ABOUT %>"><span class="icon fa-hospital-o" style="padding-right:5px;"></span>このサイトについて</a></li>
								<li class="<%=mainMenuSelect != null && mainMenuSelect.equals(Constants.MAIN_MENU_SELECT_CONTACT) ? "current" : "" %>" style="white-space: nowrap;"><a href="/info/<%=Constants.MAIN_MENU_SELECT_CONTACT %>"><span class="icon fa-envelope" style="padding-right:5px;"></span>お問い合わせ</a></li> --%>
							</ul>
						</nav>