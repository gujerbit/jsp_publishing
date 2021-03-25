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
	
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String empName = request.getParameter("empName");
	String joinDate = request.getParameter("joinDate");
	String rank = request.getParameter("rank");
	String dept = request.getParameter("dept");
%>
	<main>
		<h1>사원정보 수정</h1>
		<form name="regForm" action="EmpUpdate.do" method="post" onsubmit="return check();">
			<table border="1">
				<tr>
					<th>사원번호</th> <td><input type="text" name="empNo" value="<%= empNo %>" readonly></td>
				</tr>
				<tr>
					<th>사원이름</th> <td><input type="text" name="empName" value="<%= empName %>"></td>
				</tr>
				<tr>
					<th>입사일자</th> <td><input type="text" name="joinDate" value="<%= joinDate %>" readonly></td>
				</tr>
				<tr>
					<th>직급</th>
					<td>
						<select name="rank">
<%
	if(rank.equals("A")) {
%>
							<option value="A" selected>사원</option>
							<option value="B">대리</option>
							<option value="C">과장</option>
<%
	} else if(rank.equals("B")) {
%>
							<option value="A">사원</option>
							<option value="B" selected>대리</option>
							<option value="C">과장</option>
<%
	} else if(rank.equals("C")) {
%>
							<option value="A">사원</option>
							<option value="B">대리</option>
							<option value="C" selected>과장</option>
<%
	}
%>
						</select>
					</td>
				</tr>
				<tr>
					<th>부서</th>
					<td>
						<select name="dept">
<%
	if(dept.equals("A")) {
%>
							<option value="A" selected>디자인</option>
							<option value="B">백엔드</option>
							<option value="C">프론트</option>
<%
	} else if(dept.equals("B")) {
%>
							<option value="A">디자인</option>
							<option value="B" selected>백엔드</option>
							<option value="C">프론트</option>
<%
	} else if(dept.equals("C")) {
%>
							<option value="A">디자인</option>
							<option value="B">백엔드</option>
							<option value="C" selected>프론트</option>
<%
	}
%>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정"> <input type="reset" value="다시 입력">
					</td>
				</tr>
			</table>
		</form>
	</main>
<jsp:include page="footer.jsp"/>