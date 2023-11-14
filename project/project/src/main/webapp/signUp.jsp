<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
<a href="project.jsp">로그인</a>
<form action="Create.do" method="post">
 아이디:<input type="text" name="ID"><br>
 비밀번호:<input type="password" name="passwd"><br>
<button type="submit">가입</button>
</form>
</body>
</html>