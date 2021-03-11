<%@page import="vo.MemberVO"%>
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
			location.href='Select.do';
		</script>
<%
	} else if(request.getAttribute("error") != null) {
		String error = (String)request.getAttribute("error");
%>
		<script>
			alert('<%= error %>');
			location.href='Select.do';
		</script>
<%	
	}

	MemberDAO dao = MemberDAO.getInstance();
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
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
<form action="Update.do" method="post" name="regForm" onsubmit="return check();">
	<table border="1">
		<tr>
			<td>회원번호</td> <td><input type="text" value="<%= id %>" name="id" readonly></td>
		</tr>
		<tr>
			<td>회원성명</td> <td><input type="text" name="name" value="<%= name %>"></td>
		</tr>
		<tr>
			<td>회원전화</td> <td><input type="text" name="phone" value="<%= phone %>"></td>
		</tr>
		<tr>
			<%
				if(address.equals("SK")) {
			%>
					<td>통신사 [SK, KT, LG]</td> <td><input type="radio" name="address" value="SK" checked>SK <input type="radio" name="address" value="KT">KT <input type="radio" name="address" value="LG">LG</td>
			<%
				} else if(address.equals("KT")) {
			%>
					<td>통신사 [SK, KT, LG]</td> <td><input type="radio" name="address" value="SK">SK <input type="radio" name="address" value="KT" checked>KT <input type="radio" name="address" value="LG">LG</td>
			<%	
				} else if(address.equals("LG")) {
			%>
					<td>통신사 [SK, KT, LG]</td> <td><input type="radio" name="address" value="SK">SK <input type="radio" name="address" value="KT">KT <input type="radio" name="address" value="LG" checked>LG</td>
			<%	
				}
			%>
		</tr>
		<tr>
			<td>가입일자</td> <td><input type="text" name="joindate" value="<%= joindate %>" readonly></td>
		</tr>
		<tr>
			<%
				if(grade.equals("VIP")) {
			%>
					<td>고객등급 [A:VIP, B:일반, C:직원]</td>
					<td>
						<select name="grade">
							<option value="A" selected>A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
			<%
				} else if(grade.equals("일반")) {
			%>
					<td>고객등급 [A:VIP, B:일반, C:직원]</td>
					<td>
						<select name="grade">
							<option value="A">A</option>
							<option value="B" selected>B</option>
							<option value="C">C</option>
						</select>
					</td>
			<%
				} else if(grade.equals("직원")) {
			%>
					<td>고객등급 [A:VIP, B:일반, C:직원]</td>
					<td>
						<select name="grade">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C" selected>C</option>
						</select>
					</td>
			<%
				}
			%>
		</tr>
		<tr>
			<td>도시코드</td> <td><input type="text" name="city" value="<%= city %>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<button onclick="location.href='Select.do'">조회</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="footer.jsp"/>