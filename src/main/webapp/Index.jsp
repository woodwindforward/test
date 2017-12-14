<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>足球联赛</h1>
	<ul>
		<li><a href="getLeaguesAction">列出所有联赛</a></li>
		<li><a href="register/EnterPlayer.jsp">注册联赛</a></li>
	</ul>
	<h1>管理员</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath }/admin/authenAction?page=/admin/AddLeague.jsp">添加新联赛</a></li>
		<li><a href="${pageContext.request.contextPath }/admin/authenAction?page=/admin/getPlayersAction">球员信息列表</a></li>
		<li><a href="${pageContext.request.contextPath }/admin/authenAction?page=/Index.jsp">登录</a></li>
	</ul>
</body>
</html>