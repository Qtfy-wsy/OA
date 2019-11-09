<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Test/geTests">显示用户信息</a><br/>
<form action="User/getUser">
<input type="text" name="id"/>
<input type="submit" value="查找用户信息"/>
</form>
<br/>
<form action="User/addUser">
用户名：<input type="text" name="uname"/>
密码：<input type="text" name="upwd"/>
昵称：<input type="text" name="nickName"/>
<input type="submit" value="添加用户"/>
</form>

</body>
</html>