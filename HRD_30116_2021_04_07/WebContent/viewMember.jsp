<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%
	if(request.getAttribute("list") == null) {
%>
<h1>인사관리조회화면</h1>
<main class="view">
<p>인사관리 조회</p>
<form action="View.do" method="get">
	<input type="radio" name="type" value="1" checked> 사원번호로 조회 <input type="text" name="id"> <br>
	<input type="radio" name="type" value="2"> 부서명으로 조회
	<select name="dept">
<%
	String[] arr = {"인사부", "기획부", "홍보부", "영업부", "경리부"};

	for(int i = 0; i < arr.length; i++) {
%>
		<option value="<%= arr[i] %>"><%= arr[i] %></option>
<%
	}
%>
	</select> <br>
	<input type="submit" value="조회" class="btn"> <button type="button" onclick="location.href='index.jsp'">취소</button>
</form>
</main>
<%
	} else {
%>
<h2>직원 정보 조회 결과</h2>
<hr>
<table border="1">
	<tr>
		<th>성명</th> <th>사번</th> <th>직급</th> <th>직책</th> <th>연락처</th> <th>소속부서</th>
	</tr>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");

	for(MemberVO vo : list) {
%>
	<tr>
		<td><%= vo.getName() %></td> <td><%= vo.getId() %></td> <td><%= vo.getPosition() %></td> <td><%= vo.getDuty() %></td> <td><%= vo.getPhone() %></td> <td><%= vo.getDept() %></td>
	</tr>
<%
	}
%>
</table> <br>
<button onclick="location.href='index.jsp'">확인</button>
<%
	}
%>
<jsp:include page="footer.jsp"/>