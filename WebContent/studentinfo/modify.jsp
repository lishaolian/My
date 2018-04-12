<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sms.model.StudentInfo" %>
<%@ page import="com.sms.dao.StudentInfoDao"%>
<%@ page import="com.sms.web.PermissionHelper"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<%
    if(!PermissionHelper.validPermission(request, response,"StudentModif"))return;
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	StudentInfoDao dao = new StudentInfoDao(request);
	StudentInfo c = dao.get(Long.parseLong(id));
%>
<body>
	<h2 align="center">修改学生信息</h2>
	<hr/>
	<div style="margin:10px;">
		<form method="post" action="/ModifyS.do">
			<input type="hidden" name="id" value="<%=c.getId()%>" >
			学生名称：<input type="text" name="name" value="<%=c.getName()%>">
			班级名称：<input type="text" name="ClassName" value="<%=c.getClassName()%>">
			<input type="submit" name="submit" value="确定">
		</form>
	</div>
</body>
</html>
</html>
