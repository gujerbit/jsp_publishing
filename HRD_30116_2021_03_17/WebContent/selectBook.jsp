<%@page import="vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<BookVO> list1 = null;
	ArrayList<BookVO> list2 = null;
	if(request.getAttribute("list1") != null) list1 = (ArrayList<BookVO>)request.getAttribute("list1");
	if(request.getAttribute("list2") != null) list2 = (ArrayList<BookVO>)request.getAttribute("list2");
%>
<h1>회원별 대여현황</h1>
<table border="1">
	<tr>
		<td>회원번호</td> <td>회원이름</td> <td>대여횟수</td>
	</tr>
<%
	for(BookVO vo : list1) {
%>
		<tr>
			<td><%= vo.getCustno() %></td> <td><%= vo.getCustname() %></td> <td><%= vo.getMemberTotal() %></td>
		</tr>
<%
	}
%>
</table>
<h1>도서별 대여현황</h1>
<table border="1">
	<tr>
		<td>도서번호</td> <td>대여횟수</td>
	</tr>
<%
	for(BookVO vo : list2) {
%>
		<tr>
			<td><%= vo.getBookno() %></td> <td><%= vo.getBookTotal() %></td>
		</tr>
<%
	}
%>
</table>
<jsp:include page="footer.jsp"/>