<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	String msg = null;
	if(request.getAttribute("msg") != null) {
		msg = (String)request.getAttribute("msg");
%>
		<script>
			alert('<%= msg %>');
			location.href='index.jsp';
		</script>
<%
	}
%>
<jsp:include page="footer.jsp"/>