<%@page import="vo.CourseVO"%>
<%@page import="java.util.ArrayList"%>
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
	
	CourseVO vo = null;
	if(request.getAttribute("vo") != null) {
		vo = (CourseVO)request.getAttribute("vo");
%>
<h1>교과목 수정</h1>
<form action="UpdateCourse.do?type=2" method="post">
	<table border="1">
		<tr>
			<th>교과목 코드</th> <td><input type="text" name="id" value=<%= vo.getId() %> readonly></td>
		</tr>
		<tr>
			<th>과목명</th> <td><input type="text" name="name" value="<%= vo.getName() %>"></td>
		</tr>
		<tr>
			<th>담당강사</th>
			<td>
				<select name="lecName">
<%
	ArrayList<String> list = new ArrayList<String>();
		if(request.getAttribute("list") != null) list = (ArrayList<String>)request.getAttribute("list");
	
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(vo.getLecName())) {
%>
					<option value="<%= i+1 %>" selected><%= list.get(i) %></option>
<%
				} else {
%>
					<option value="<%= i+1 %>"><%= list.get(i) %></option>	
<%
				}
			}
%>
				</select>
			</td>
		</tr>
		<tr>
			<th>학점</th> <td><input type="text" name="credit" value="<%= vo.getCredit() %>"></td>
		</tr>
		<tr>
			<th>요일</th>
			<td>
<%
			if(vo.getWeek() == 1) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2">화 <input type="radio" name="week" value="3">수 <input type="radio" name="week" value="4">목 <input type="radio" name="week" value="5">금 <input type="radio" name="week" value="6">토
<%
			} else if(vo.getWeek() == 2) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2" checked>화 <input type="radio" name="week" value="3">수 <input type="radio" name="week" value="4">목 <input type="radio" name="week" value="5">금 <input type="radio" name="week" value="6">토
<%
			} else if(vo.getWeek() == 3) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2">화 <input type="radio" name="week" value="3" checked>수 <input type="radio" name="week" value="4">목 <input type="radio" name="week" value="5">금 <input type="radio" name="week" value="6">토
<%
			} else if(vo.getWeek() == 4) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2">화 <input type="radio" name="week" value="3">수 <input type="radio" name="week" value="4" checked>목 <input type="radio" name="week" value="5">금 <input type="radio" name="week" value="6">토
<%
			} else if(vo.getWeek() == 5) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2">화 <input type="radio" name="week" value="3">수 <input type="radio" name="week" value="4">목 <input type="radio" name="week" value="5" checked>금 <input type="radio" name="week" value="6">토
<%
			} else if(vo.getWeek() == 6) {
%>
		<input type="radio" name="week" value="1">월 <input type="radio" name="week" value="2">화 <input type="radio" name="week" value="3">수 <input type="radio" name="week" value="4">목 <input type="radio" name="week" value="5">금 <input type="radio" name="week" value="6" checked>토
<%
			}
%>
				     
			</td>
		</tr>
		<tr>
			<th>시작</th> <td><input type="text" name="start" value="<%= vo.getStart() %>"></td>
		</tr>
		<tr>
			<th>종료</th> <td><input type="text" name="end" value="<%= vo.getEnd() %>"></td>
		</tr>
<%
	}
%>
	</table>
	<input type="reset" value="취소">
	<input type="submit" value="완료">
</form>
<button onclick="location.href='ViewCourse.do'">목록</button>
<jsp:include page="footer.jsp"/>