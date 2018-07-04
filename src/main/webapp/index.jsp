<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>SpringMemberMVC 메인 페이지</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="/login.do" method="POST" accept-charset="utf-8">
		아이디 <input type="text" name="userId" placeholder="아이디 입력"><br>
		비밀번호 <input type="password" name="userPw" placeholder="비밀번호 입력"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>