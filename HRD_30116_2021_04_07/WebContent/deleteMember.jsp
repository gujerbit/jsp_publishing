<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h1>인사관리 퇴사처리 화면</h1>
<main class="del">
<p>인사관리 사원정보 변경</p>
<form action="Delete.do" method="post">
	성명 <span>: <input type="text" name="name"></span> <br>
	사원번호 <span>: <input type="text" name="id"></span> <br>
	<input type="submit" value="삭제" class="btn"> <button type="button" onclick="location.href='index.jsp'">취소</button>
</form>
</main>
<jsp:include page="footer.jsp"/>