<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sms.model.StudentInfo" %>
<%@ page import="com.sms.dao.StudentInfoDao"%>
<%@ page import="com.sms.web.PermissionHelper"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理</title>
</head>
<%
    if(!PermissionHelper.validPermission(request, response,"StudentList"))return;
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("stuname");
	List<StudentInfo> list = new StudentInfoDao(request).query(name);
%>
<body>
<h2 align="center">学生信息管理</h2>
	<hr/>
	<div style="margin:10px;">
		<form method="post" action="list.jsp">
			学生名字：<input type="text" name="stuname">
			<input type="submit" value="查询">
		</form>
	</div>
	<a href="/studentinfo/add.jsp">添加学生</a>
	<table border="1" width="50%">
		<tr>
			<th>学生编号</th>
			<th>学生名字</th>
			<th>班级名称</th>
			<th>操作</th>
		</tr>
		<%
		for(StudentInfo c:list){
		%>
			<tr>
				<td><%=c.getId() %></td>
				<td><%=c.getName() %></td>
				<td><%=c.getClassName() %></td>
				<td>
				<a href="/studentinfo/modify.jsp?id=<%=c.getId() %>">修改</a>
				<a href="../DeleteS.do?id=<%=c.getId() %>">删除</a>
				</td>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>