<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>输入球员信息</h1>
	<c:forEach items="${errors}" var="err">
		<li>${err}
	</c:forEach>
	<form action="${pageContext.request.contextPath}/register/enterPlayerAction" method="post">
		姓名：<input type="text" name="name" value="${param.name}"><br>
		地址：<input type="text" name="address" value="${param.address}"><br>
		城市：<input type="text" name="city" value="${param.city}"><br>
		邮箱：<input type="text" name="email" value="${param.email}"><br>
		<input type="submit" value="继续...">
	</form>
</body>
</html>