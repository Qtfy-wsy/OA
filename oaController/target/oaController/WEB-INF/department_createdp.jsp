<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 建立部门——名称 -->
<form action="" method="get">
部门名称: <input type="text" name="department_name" />
  <input type="submit" value="Submit" />
</form>
<!--  建立某部门下所需职位-->
<form action="" method="get">
<table>
	<tbody>
				<c:forEach var="user" items="${部门列表}">
					<tr>
						<td><input type="radio" name="id" value="${部门ID}"/></td><td>${部门name}</td><td>${上级部门 }</td>
					<tr>
					<!-- 循环读取职位 -->
					<tr><td>${已有职位一览 }</td></tr>
				</c:forEach>
			</tbody>
</table>
职位名称: <input type="text" name="department_role" />
  <input type="submit" value="Submit" />
</form>
</body>
</html>