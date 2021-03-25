<%@page import="vo.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<EmpVO> list = null;
	if(request.getAttribute("list") != null) list = (ArrayList<EmpVO>)request.getAttribute("list"); 
%>
	<main>
		<h1>회원목록 조회/수정</h1>
		<table border="1">
			<tr>
				<th>사원번호</th> <th>사원이름</th> <th>입사일자</th> <th>직급</th> <th>부서</th> <th>기능</th>
			</tr>
<%
	for(EmpVO vo : list) {
		String rank = null;
		String dept = null;
		
		if(vo.getRank().equals("A")) {
			rank = "사원";
		} else if(vo.getRank().equals("B")) {
			rank = "대리";
		} else if(vo.getRank().equals("C")) {
			rank = "과장";
		}
		
		if(vo.getDept().equals("A")) {
			dept = "디자인";
		} else if(vo.getDept().equals("B")) {
			dept = "백엔드";
		} else if(vo.getDept().equals("C")) {
			dept = "프론트";
		}
%>
			<tr>
				<td><%= vo.getEmpNo() %></td> <td><%= vo.getEmpName() %></td> <td><%= vo.getJoinDate() %></td> <td><%= rank %></td> <td><%= dept %></td> <td><button onclick="location.href='empUpdate.jsp?empNo=<%= vo.getEmpNo() %>&empName=<%= vo.getEmpName() %>&joinDate=<%= vo.getJoinDate() %>&rank=<%= vo.getRank() %>&dept=<%= vo.getDept() %>'">수정</button></td>
			</tr>
<%
	}
%>
		</table>
	</main>
<jsp:include page="footer.jsp"/>