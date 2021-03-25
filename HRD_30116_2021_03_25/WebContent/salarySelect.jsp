<%@page import="vo.SalaryVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<SalaryVO> list = null;
	if(request.getAttribute("list") != null) list = (ArrayList<SalaryVO>)request.getAttribute("list");
%>
	<main>
		<h1>사원급여 조회</h1>
		<table border="1">
			<tr>
				<th>회원번호</th> <th>회원이름</th> <th>총 급여</th>
			</tr>
<%
	for(SalaryVO vo : list) {
%>
			<tr>
				<td><%= vo.getEmpNo() %></td> <td><%= vo.getEmpName() %></td> <td><%= vo.getPay() %></td>
			</tr>
<%
	}
%>
		</table>
	</main>
<jsp:include page="footer.jsp"/>