<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h1>인사관리 사원등록화면</h1>
<main class="set">
<p>인사관리 사원등록</p>
<form action="Set.do" method="post">
	성명 <span>: <input type="text" name="name"></span> <br>
	사원번호 <span>: <input type="text" name="id"></span> <br>
	소속부서 <span>: 
	<select name="dept">
<%
	String[] arr = {"인사부", "기획부", "홍보부", "영업부", "경리부"};

	for(int i = 0; i < arr.length; i++) {
%>
		<option value="<%= arr[i] %>"><%= arr[i] %></option>
<%
	}
%>
	</select></span> <br>
	직급 <span>: 
	<select name="position">
<%
	String[] positions = {"1급", "2급", "3급", "4급"};

	for(int i = 0; i < positions.length; i++) {
%>
		<option value="<%= i+1 %>"><%= positions[i] %></option>
<%
	}
%>
	</select></span> <br>
	직책 <span>: <input type="text" name="duty"></span> <br>
	연락처 <span>: <input type="text" name="phone"></span> <br>
	<input type="submit" value="등록" class="btn"> <button type="button" onclick="location.href='index.jsp'">취소</button>
</form>
</main>
<jsp:include page="footer.jsp"/>