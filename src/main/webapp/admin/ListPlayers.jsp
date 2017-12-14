<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>所有球员信息</h1>      <!-- 球员个人信息以及所在联赛信息 -->
	<ul>
		<c:forEach items="${players }" var="player">
			<li>${player }</li>
		</c:forEach>
	</ul>
	<a href="${pageContext.request.contextPath }/Index.jsp">返回首页</a>
</body>
</html>