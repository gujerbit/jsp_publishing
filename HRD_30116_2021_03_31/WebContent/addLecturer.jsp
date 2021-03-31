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
	int nextNo = 0;
	if(request.getAttribute("nextNo") != null) nextNo = (int)request.getAttribute("nextNo");
%>
<h1>강사 추가</h1>
<form action="AddLecturer.do?type=2" method="post">
	<table border="1">
		<tr>
			<th>번호</th> <td><input type="text" name="idx" value="<%= nextNo %>" readonly></td>
		</tr>
		<tr>
			<th>강사명</th> <td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>전공</th> <td><input type="text" name="major"></td>
		</tr>
		<tr>
			<th>연구분야</th> <td><input type="text" name="field"></td>
		</tr>
	</table>
	<input type="submit" value="완료">
</form>
<jsp:include page="footer.jsp"/>