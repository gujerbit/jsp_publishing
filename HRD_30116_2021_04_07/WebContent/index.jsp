<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script>
	function winClose() {
		window.open('', '_self').close();
	}
</script>
<h1>인사관리시스템</h1>
<main class="home">
	<p>인사관리 메인메뉴</p>
	<button onclick="location.href='viewMember.jsp'">조회</button>
	<button onclick="location.href='setMember.jsp'">사원등록</button>
	<button onclick="location.href='updateMember.jsp'">정보변경</button> <br>
	<button onclick="location.href='deleteMember.jsp'">퇴사처리</button>
	<button class="closeBtn" onclick="winClose();">종료</button>
</main>
<jsp:include page="footer.jsp"/>