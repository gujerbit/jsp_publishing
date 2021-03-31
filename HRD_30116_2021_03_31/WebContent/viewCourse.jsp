<%@page import="vo.CourseVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<CourseVO> list = new ArrayList<CourseVO>();
	if(request.getAttribute("list") != null) list = (ArrayList<CourseVO>)request.getAttribute("list");
%>
<h1>교과목 조회</h1>
<table border="1">
	<tr>
		<th>과목코드</th> <th>과목명</th> <th>학점</th> <th>담당강사</th> <th>요일</th> <th>시작시간</th> <th>종료시간</th> <th>관리</th>
	</tr>
<%
	for(CourseVO vo : list) {
		String week = "";
		if(vo.getWeek() == 1) {
			week = "월";
		} else if(vo.getWeek() == 2) {
			week = "화";
		} else if(vo.getWeek() == 3) {
			week = "수";
		} else if(vo.getWeek() == 4) {
			week = "목";
		} else if(vo.getWeek() == 5) {
			week = "금";
		} else if(vo.getWeek() == 6) {
			week = "토";
		}
		
		if(vo.getStart() < 1000 && vo.getEnd() < 1000) {
%>
		<tr>
			<td><%= vo.getId() %></td> <td><%= vo.getName() %></td> <td><%= vo.getCredit() %></td> <td><%= vo.getLecName() %></td> <td><%= week %></td> <td>0<%= vo.getStart() %></td> <td>0<%= vo.getEnd() %></td> <td><a href="UpdateCourse.do?type=1&id=<%= vo.getId() %>&name=<%= vo.getName() %>&credit=<%= vo.getCredit() %>&lecName=<%= vo.getLecName() %>&week=<%= vo.getWeek() %>&start=<%= vo.getStart() %>&end=<%= vo.getEnd() %>">수정</a> / <a href="DeleteCourse.do?id=<%= vo.getId() %>">삭제</a></td>
		</tr>
<%
		} else if(vo.getStart() < 1000 && vo.getEnd() >= 1000) {
%>
		<tr>
			<td><%= vo.getId() %></td> <td><%= vo.getName() %></td> <td><%= vo.getCredit() %></td> <td><%= vo.getLecName() %></td> <td><%= week %></td> <td>0<%= vo.getStart() %></td> <td><%= vo.getEnd() %></td> <td><a href="UpdateCourse.do?type=1&id=<%= vo.getId() %>&name=<%= vo.getName() %>&credit=<%= vo.getCredit() %>&lecName=<%= vo.getLecName() %>&week=<%= vo.getWeek() %>&start=<%= vo.getStart() %>&end=<%= vo.getEnd() %>">수정</a> / <a href="DeleteCourse.do?id=<%= vo.getId() %>">삭제</a></td>
		</tr>
<%
		} else if(vo.getStart() >= 1000 && vo.getEnd() < 1000) {
%>
		<tr>
			<td><%= vo.getId() %></td> <td><%= vo.getName() %></td> <td><%= vo.getCredit() %></td> <td><%= vo.getLecName() %></td> <td><%= week %></td> <td><%= vo.getStart() %></td> <td>0<%= vo.getEnd() %></td> <td><a href="UpdateCourse.do?type=1&id=<%= vo.getId() %>&name=<%= vo.getName() %>&credit=<%= vo.getCredit() %>&lecName=<%= vo.getLecName() %>&week=<%= vo.getWeek() %>&start=<%= vo.getStart() %>&end=<%= vo.getEnd() %>">수정</a> / <a href="DeleteCourse.do?id=<%= vo.getId() %>">삭제</a></td>
		</tr>
<%
		} else {
%>
		<tr>
			<td><%= vo.getId() %></td> <td><%= vo.getName() %></td> <td><%= vo.getCredit() %></td> <td><%= vo.getLecName() %></td> <td><%= week %></td> <td><%= vo.getStart() %></td> <td><%= vo.getEnd() %></td> <td><a href="UpdateCourse.do?type=1&id=<%= vo.getId() %>&name=<%= vo.getName() %>&credit=<%= vo.getCredit() %>&lecName=<%= vo.getLecName() %>&week=<%= vo.getWeek() %>&start=<%= vo.getStart() %>&end=<%= vo.getEnd() %>">수정</a> / <a href="DeleteCourse.do?id=<%= vo.getId() %>">삭제</a></td>
		</tr>
<%
		}
	}
%>
</table>
<jsp:include page="footer.jsp"/>