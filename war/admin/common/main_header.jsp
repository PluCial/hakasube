<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%
String pageTitle = (String) request.getAttribute("pageTitle");
%>
			<div id="header-wrapper">
				<div id="header">
					<!-- Logo -->
					<h1><span style="font-size:0.8em"><%=pageTitle %></span></h1>
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li style="white-space: nowrap;"><a href="/admin/category"><span class="icon fa-folder-open" style="padding-right:5px;"></span>カテゴリ管理</a></li>
								<li style="white-space: nowrap;"><a href="/admin/article"><span class="icon fa-desktop" style="padding-right:5px;"></span>記事管理</a></li>
								<li style="white-space: nowrap;"><a href="/admin/articleAdd"><span class="icon fa-plus" style="padding-right:5px;"></span>記事追加</a></li>
								<li style="white-space: nowrap;"><a href="/admin/setting"><span class="icon fa-cog" style="padding-right:5px;"></span>システム設定</a></li>
							</ul>
						</nav>
				</div>
			</div>
