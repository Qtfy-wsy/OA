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
	<form id="form1" onsubmit="return false" action="##" method="post">
	<input type="hidden" name="permissionId" value="${permissionId}"/>
	<span>
		用户Id：<span>${userDuty.userId}</span>
		<input type="hidden" name="userId" value="${userDuty.userId}"/>
	</span>
	<span>
		<select id="duty" onchange="dutyChange(this.value)" name="dutyType">
			<option value="0">-----班次-----</option>
			<c:forEach var="duty" items="${duties }">
				<option value="${duty.dutyType }">${duty.dutyType }--${duty.dutyName }</option>
			</c:forEach>
		</select>
		<span>原班次：${userDuty.userDuty.dutyType}--${userDuty.userDuty.dutyName}</span>
	</span>
	<span><input type="button" value="提交" onclick="sub()"/></span>
	<span><input type="reset" value="重置"></span>
	</form>
</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
var flag=false;
function dutyChange(duty) {
	if(duty!=0){
		flag=true;
	}else{flag=false;}
}
function sub(){
	if(flag){
		$.ajax({
                type: "POST",//方法类型
                dataType: "text",//预期服务器返回的数据类型
                url: "updateUserDutyEnd" ,//url
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