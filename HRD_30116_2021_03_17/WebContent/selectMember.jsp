<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<h1>회원목록 조회 / 수정</h1>
<table border="1">
	<tr>
		<td>회원번호</td> <td>회원이름</td> <td>가입일자</td> <td>고객등급</td> <td>주소</td> <td>기능</td>
	</tr>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	if(request.getAttribute("list") != null) list = (ArrayList<MemberVO>)request.getAttribute("list");
	
	for(MemberVO vo : list) {
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
			<td><%= vo.getCustno() %></td> <td><%= vo.getCustname() %></td> <td><%= vo.getJoindate().toString().substring(0, vo.getJoindate().toString().length() - 11) %></td> <td><%= grade %></td> <td><%= vo.getAddress() %></td> <td><div class="update"><a href="Update.do?type=1&custno=<%= vo.getCustno() %>">수정</a></div></td>			
		</tr>
<%
	}
%>
</table>
<jsp:include page="footer.jsp"/>