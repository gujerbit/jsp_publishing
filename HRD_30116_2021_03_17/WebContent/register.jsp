<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
	
	int custno = 0;
	String joindate = "";
	MemberDTO dto = null;
	
	if(request.getAttribute("dto") != null) {
		dto = (MemberDTO)request.getAttribute("dto");
		custno = dto.getCustno();
		joindate = dto.getJoindate();
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
<form name="regForm" action="Register.do?type=2" method="post" onsubmit="return check();">
	<table class="regTable" border="1">
		<tr>
			<td>회원번호</td> <td><input type="text" name="custno" value="<%= custno %>" id="custno" readonly></td>
		</tr>
		<tr>
			<td>회원이름</td> <td><input type="text" name="custname" id="custname"></td>
		</tr>
		<tr>
			<td>가입일자</td> <td><input type="text" name="joindate" value="<%= joindate %>" id="joindate" readonly></td>
		</tr>
		<tr>
			<td>고객등급</td>
			<td>
				<select name="grade" id="grade">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>주소</td> <td><input type="text" name="address" id="address"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="다시 입력">
			</td>
		</tr>
	</table>
</form>
<%
	}
%>
<jsp:include page="footer.jsp"/>