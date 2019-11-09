<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<form method="post">
	<c:forEach var="o" items="${operate.operateList}">
		<input type="submit" formaction="${o.operateAction}?permissionId=${o.permissionId}" formtarget="_blank" value="${o.operateName}" >
	</c:forEach>
		<thead>
			<tr>
				<td>用户名</td><td>密码</td><td>昵称</td><td>上级id</td>
			</tr>
		</thead>
	
		
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><input type="radio" name="id" value="${user.userId}"/></td><td>${user.uname }</td><td>${user.upwd }</td><td>${user.nickName }</td><td>${user.leaderId }</td>
					<tr>
				</c:forEach>
			</tbody>
	</form>
</table>
</body>
</html>