<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	if(request.getAttribute("list") != null) {
		list = (ArrayList<MemberVO>)request.getAttribute("list");
	}
%>
<h1>회원목록조회/수정</h1>
<table border="1">
	<tr>
		<td>회원번호</td> <td>회원성명</td> <td>전화번호</td> <td>통신사</td> <td>가입일자</td> <td>고객등급</td> <td>거주지역</td>
	</tr>
<%
		for(MemberVO vo : list) {
			String grade = "";
			if(vo.getGrade().equals("A")) {
				grade = "VIP";
			} else if(vo.getGrade().equals("B")) {
				grade = "일반";
			} else if(vo.getGrade().equals("C")) {
				grade = "직원";
			}
			
			String city = "";
			if(vo.getCity().equals("01")) {
				city = "서울";
			} else if(vo.getCity().equals("10")) {
				city = "인천";
			} else if(vo.getCity().equals("20")) {
				city = "성남";
			} else if(vo.getCity().equals("30")) {
				city = "대전";
			} else if(vo.getCity().equals("40")) {
				city = "광주";
			} else if(vo.getCity().equals("60")) {
				city = "부산";
			}
%>
			<tr>
				<td><a href="Update.do"><%= vo.getCustno() %></a></td> <td><%= vo.getCustname() %></td> <td><%= vo.getPhone() %></td> <td><%= vo.getAddress() %></td> <td><%= vo.getJoindate().toString().substring(0, vo.getJoindate().toString().length()-10) %></td> <td><%= grade %></td> <td><%= city %></td>
			</tr>			
<%
		}
%>
</table>
<jsp:include page="footer.jsp"/>