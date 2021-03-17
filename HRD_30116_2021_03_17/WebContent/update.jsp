<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	if(request.getAttribute("success") != null) {
		String msg = (String)request.getAttribute("success");
%>
		<script>
			alert('<%= msg %>');
			location.href='index.jsp';
		</script>
<%
	} else if(request.getAttribute("error") != null) {
		String msg = (String)request.getAttribute("error");
%>
		<script>
			alert('<%= msg %>');
			location.href='index.jsp';
		</script>
<%
	}
	
	MemberVO vo = null;

	if(request.getAttribute("vo") != null) {
		vo = (MemberVO)request.getAttribute("vo");
%>
<script type="text/javascript">
	function check() {
		if(document.regForm.custname.value == "") {
			console.log(document.regForm.custname.value);
			alert('회원이름은 필수 값입니다!');
			document.regForm.custname.focus();
			return false;
		} else if(document.regForm.address.value == "") {
			console.log(document.regForm.address.value);
			alert('주소는 필수 값입니다!');
			document.regForm.address.focus();
			return false;
		} else if(document.regForm.custname.value.length > 3) {
			alert('회원이름은 최대 3글자 까지 입력하실 수 있습니다!');
			document.regForm.custname.focus();
			return false;
		}
		
		document.regForm.submit();
	}
</script>
<h1>회원등록 화면</h1>
<form name="regForm" action="Update.do?type=2" method="post" onsubmit="return check();">
	<table class="regTable" border="1">
		<tr>
			<td>회원번호</td> <td><input type="text" name="custno" value="<%= vo.getCustno() %>" id="custno" readonly></td>
		</tr>
		<tr>
			<td>회원이름</td> <td><input type="text" name="custname" id="custname" value="<%= vo.getCustname() %>"></td>
		</tr>
		<tr>
			<td>가입일자</td> <td><input type="text" name="joindate" value="<%= vo.getJoindate().toString().substring(0, vo.getJoindate().toString().length() - 11) %>" id="joindate" readonly></td>
		</tr>
		<tr>
			<td>고객등급</td>
			<td>
				<select name="grade" id="grade">
<%
	if(vo.getGrade().equals("A")) {
%>
					<option value="A" selected>A</option>
					<option value="B">B</option>
					<option value="C">C</option>
<%	
	} else if(vo.getGrade().equals("B")) {
%>
					<option value="A">A</option>
					<option value="B" selected>B</option>
					<option value="C">C</option>
<%
	} else if(vo.getGrade().equals("C")) {
%>
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C" selected>C</option>
<%
	}
%>
				</select>
			</td>
		</tr>
		<tr>
			<td>주소</td> <td><input type="text" name="address" id="address" value="<%= vo.getAddress() %>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="reset" value="다시 입력">
			</td>
		</tr>
	</table>
</form>
<%
	}
%>
<jsp:include page="footer.jsp"/>