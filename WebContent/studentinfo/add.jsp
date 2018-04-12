<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生信息</title>
</head>
<body>
<h2 align="center">添加学生信息</h2>
	<hr/>
	<div style="margin:10px;">
		<form method="post" action="../AddS.do">
			学生名字：<input type="text" name="stuname">
			班级名称：<input type="text" name="ClassName">
			<input type="submit" name="submit" value="确定">
		</form>
	</div>
</body>
</html>