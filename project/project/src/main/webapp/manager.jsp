<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.java.bean.*"%>
<%
	ArrayList<RegisterDTO> alist = (ArrayList<RegisterDTO>)session.getAttribute("userList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>관리자 페이지</h1>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
	</tr>
	<%
	for(int i=0; i<alist.size(); i++){
		RegisterDTO mb = (RegisterDTO)alist.get(i);
	%>
	<tr>
	<td><%=mb.getMemberid()%></td>
	<td><%=mb.getPassword()%></td>
	</tr>
	<%} %>
</table>
</body>
</html>