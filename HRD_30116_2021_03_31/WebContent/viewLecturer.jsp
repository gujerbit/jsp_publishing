<%@page import="vo.LecturerVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<h1>강사 조회</h1>
<table border="1">
	<tr>
		<th>번호</th> <th>강사명</th> <th>전공</th> <th>연구분야</th> <th>기능</th>
	</tr>
<%
	ArrayList<LecturerVO> list = new ArrayList<LecturerVO>();
	if(request.getAttribute("list") != null) list = (ArrayList<LecturerVO>)request.getAttribute("list");
	
	for(LecturerVO vo : list) {
%>
		<tr>
			<td><%= vo.getIdx() %></td> <td><%= vo.getName() %></td> <td><%= vo.getMajor() %></td> <td><%= vo.getField() %></td> <td><a href="DeleteLecturer.do?idx=<%= vo.getIdx() %>">삭제</a></td>
		</tr>
<%
	}
%>
</table>
<jsp:include page="footer.jsp"/>