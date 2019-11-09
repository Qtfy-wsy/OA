<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户排班</title>
<style type="text/css">
span{
	width:80px;
}
</style>
</head>
<body>
<div>
	<form id="form1" onsubmit="return false" action="##" method="post">选择部门：
	<input type="hidden" name="permissionId" value="${permissionId}"/>
	<span>
		<select id="department" onchange="dapartChange(this.value)" name="leaderId">
			<option value="0">-----部门-----</option>
			<c:forEach var="depart" items="${departmentList }">
				<option value="${depart.userId }">${depart.departmentName }</option>
			</c:forEach>
		</select>
	</span>
	<span>
		<select id="user" onchange="userChange(this.value)" name="userId">
			<option value="0">-----用户-----</option>
		</select>
	</span>
	<span>
		<select id="duty" onchange="dutyChange(this.value)" name="dutyType">
			<option value="0">-----班次-----</option>
			<c:forEach var="duty" items="${duties }">
				<option value="${duty.dutyType }">${duty.dutyName }</option>
			</c:forEach>
		</select>
	</span>
	<span><input type="button" value="提交" onclick="sub()"/></span>
	<span><input type="reset" value="重置"></span>
	</form>
</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
var flag=[false,false];
function dapartChange(dvalue) {
	 if(dvalue!=0){
		$.ajax({
			   type: "POST",
			   url: "../User/getDepartmentUser",
			   data: {"leaderId":dvalue},
			   dataType: "json",
			   success: function(msg){
			     	var as=eval(userList=msg);
			     	var user_div=document.getElementById("user");
			     	user_div.options.length=1;
			     	for(var i=0;i<userList.length;i++){
			     		user_div.options.add(new Option(userList[i].uname,userList[i].userId));
			     	}  
			   }
		});
	} 
}
function userChange(user) {
	if(user!=0){
		flag[0]=true;
	}else{flag[0]=false;}
}
function dutyChange(duty) {
	if(duty!=0){
		flag[1]=true;
	}else{flag[1]=false;}
}
function sub(){
	if(flag[0]&&flag[1]){
		$.ajax({
                type: "POST",//方法类型
                dataType: "text",//预期服务器返回的数据类型
                url: "addUserDutyEnd" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                	alert(result);
                },
                error : function() {
                    alert("异常！");
                }
            });
	}
}

</script>
</body>
</html>