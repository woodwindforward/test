<%@page import="java.util.List"%>
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
	<h1>添加联赛</h1>
	
	<c:if test="${not empty errors}">
		<c:forEach items="${errors}" var="err">
			<li>${err }
		</c:forEach>
	</c:if>
	<form action="${pageContext.request.contextPath}/admin/addLeagueAction" method="post">
		年份：<input type="text" name="lyear" value="${param.lyear}"><br>
		
		<c:set var="seasons" value="Spring,Summer,Fall,Winter"></c:set>
		季节：
		<select name="season">
			<option value="UNKNOWN">select...</option>			
			<c:forEach items="${seasons}" var="sea">
				<option value="${sea}"
					<c:if test="${sea == param.season}">
						selected
					</c:if>
				>${sea}</option>
			</c:forEach>			
		</select>
		<br>
		
		标题：<input type="text" name="title" value="${param.title}"> 
		<br>
		<input type="submit" value="添加新联赛">
	</form>
</body>
</html>