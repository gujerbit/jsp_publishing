<%@page import="vo.MoneyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<MoneyVO> list = new ArrayList<MoneyVO>();
	if(request.getAttribute("list") != null) {
		list = (ArrayList<MoneyVO>)request.getAttribute("list");
	}
%>
<h1>회원매출조회</h1>
<table border="1">
	<tr>
		<td>회원번호</td> <td>회원성명</td> <td>고객등급</td> <td>매출</td>
	</tr>
	<%
		for(MoneyVO vo : list) {
			String grade = "";
			
			if(vo.getGrade().equals("A")) {
				grade = "VIP";
			} else if(vo.getGrade().equals("B")) {
				grade = "일반";
			} else if(vo.getGrade().equals("C")) {
				grade = "직원";
			}
	%>
			<tr>
				<td><%= vo.getCustno() %></td> <td><%= vo.getCustname() %></td> <td><%= grade %></td> <td><%= vo.getPrice() %></td>
			</tr>		
	<%
		}
	%>
</table>
<jsp:include page="footer.jsp"/>