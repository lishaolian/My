<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sms.model.ClassInfo"%>
<%@ page import="com.sms.dao.ClassInfoDao"%>
<%@ page import="com.sms.web.PermissionHelper"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级信息</title>
</head>
<%
	if(!PermissionHelper.validPermission(request, response, "ClassModif")) return;
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	ClassInfoDao dao = new ClassInfoDao(request);
	ClassInfo c = dao.get(Long.parseLong(id));
%>
<body>
	<h2 align="center">修改班级信息</h2>
	<hr />
	<div style="margin: 10px;">
		<form method="post" action="/Modify.do">
			<input type="hidden" name="id" value="<%=c.getId()%>"> 班级名称：<input
				type="text" name="name" value="<%=c.getName()%>"> <input
				type="submit" name="submit" value="确定">
		</form>
	</div>
</body>
</html>
</html>
