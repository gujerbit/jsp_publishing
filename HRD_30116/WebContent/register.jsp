<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	if(request.getAttribute("msg") != null) {
		String msg = (String)request.getAttribute("msg");
%>
		<script>
			alert('<%= msg %>');
			location.href='index.jsp';
		</script>
<%
	} else if(request.getAttribute("error") != null) {
		String error = (String)request.getAttribute("error");
%>
		<script>
			alert('<%= error %>');
			location.href='register.jsp';
		</script>
<%
	}

	MemberDAO dao = MemberDAO.getInstance();
	int maxNo = dao.getMaxNo();
	String regDate = dao.getRegDate();
%>
<script type="text/javascript">
	function check() {
		let name = document.regForm.name.value;
		let phone = document.regForm.phone.value;
		let city = document.regForm.value;
		
		if(name == "") {
			alert('회원성명이 입력되지 않았습니다.');
			document.regForm.name.focus();
			return false;
		}
		
		if(phone == "") {
			alert('회원전화가 입력되지 않았습니다.');
			document.regForm.phone.focus();
			return false;
		}
		
		if(city == "") {
			alert('도시코드가 입력되지 않았습니다.');
			document.regForm.city.focus();
			return false;
		}
		
		return true;
	}
</script>
<h1>홈쇼핑 회원 등록</h1>
<form action="Register.do" method="post" name="regForm" onsubmit="return check();">
	<table border="1">
		<tr>
			<td>회원번호(자동발생)</td> <td><input type="text" value="<%= maxNo %>" name="id" readonly></td>
		</tr>
		<tr>
			<td>회원성명</td> <td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>회원전화</td> <td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>통신사 [SK, KT, LG]</td> <td><input type="radio" name="address" value="SK">SK <input type="radio" name="address" value="KT">KT <input type="radio" name="address" value="LG">LG</td>
		</tr>
		<tr>
			<td>가입일자</td> <td><input type="text" name="joindate" value="<%= regDate %>" readonly></td>
		</tr>
		<tr>
			<td>고객등급 [A:VIP, B:일반, C:직원]</td>
			<td>
				<select name="grade">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>도시코드</td> <td><input type="text" name="city"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<button onclick="location.href='Select.do'">조회</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="footer.jsp"/>