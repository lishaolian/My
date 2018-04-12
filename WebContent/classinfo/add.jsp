<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加班级</title>
</head>
<body>
	<h2 align="center">添加班级信息</h2>
	<hr/>
	<div style="margin:10px;">
		<form method="post" action="../Add.do">
			班级名称：<input type="text" name="name">
			<input type="submit" name="submit" value="确定">
		</form>
	</div>
</body>
</html>
