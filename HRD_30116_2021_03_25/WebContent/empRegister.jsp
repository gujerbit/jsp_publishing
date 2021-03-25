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
	
	int nextNo = 0;
	String now = null;
	
	if(request.getAttribute("nextNo") != null) nextNo = (int)request.getAttribute("nextNo");
	if(request.getAttribute("now") != null) now = (String)request.getAttribute("now");
%>
	<main>
		<h1>사원등록</h1>
		<form name="regForm" action="EmpRegister.do?type=2" method="post" onsubmit="return check();">
			<table border="1">
				<tr>
					<th>사원번호</th> <td><input type="text" name="empNo" value="<%= nextNo %>" readonly></td>
				</tr>
				<tr>
					<th>사원이름</th> <td><input type="text" name="empName"></td>
				</tr>
				<tr>
					<th>입사일자</th> <td><input type="text" name="joinDate" value="<%= now %>" readonly></td>
				</tr>
				<tr>
					<th>직급</th>
					<td>
						<select name="rank">
							<option value="A">사원</option>
							<option value="B">대리</option>
							<option value="C">과장</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>부서</th>
					<td>
						<select name="dept">
							<option value="A">디자인</option>
							<option value="B">백엔드</option>
							<option value="C">프론트</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록"> <input type="reset" value="다시 입력">
					</td>
				</tr>
			</table>
		</form>
	</main>
<jsp:include page="footer.jsp"/>