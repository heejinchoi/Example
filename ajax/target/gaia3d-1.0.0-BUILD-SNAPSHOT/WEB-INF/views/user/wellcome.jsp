<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p>로그인 되었습니다.</p>
	
	<%
	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String mobile = request.getParameter("mobile");
	String email = request.getParameter("email");
	
	out.println("userId: " + userId + "<br>");
	out.println("userName: " + userName + "<br>");
	out.println("mobile: " + mobile + "<br>");
	out.println("email: " + email + "<br>");
	
	%>
</body>
</html>