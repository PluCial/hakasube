<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%
String projectApplecationName = (String) request.getAttribute("projectApplecationName");
%>
<div id="header-wrapper">
				<div id="header">
					
					<!-- Logo -->
						<h1>
							<a href="/"><span style="font-size: 0.5em;margin-right:10px;display: none;"><%=projectApplecationName %></span><img alt="hakasube" src="http://storage.googleapis.com/hakasube.appspot.com/images/logo.png"></a>
						</h1>
					
						<jsp:include page="/common/main_header_nav.jsp" />
				</div>
			</div>