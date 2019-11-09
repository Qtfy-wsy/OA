<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>建材列表</title>
<link rel="stylesheet" href="../lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body class="pos-r">
<div style="margin-left:200px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container  pd-20">
		<form method="post" onsubmit="return sumbit_sure()">
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="50">班次编号:</th>
						<th width="50">打卡时间:</th>
						<th width="50">操作<th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="attend" items="${userAttend}">
					<tr class="text-c va-m">
					<td width="0">
					<input type="hidden" name="userId" value="${loginUser.userId}"/>
					<input type="hidden" name="registerType" value="${attend.registerType}"/>
					<input type="hidden" name="registerId" value="${attend.registerId}"/>
					<input type="hidden" name="dutyType" value="${attend.dutyType}"/>
					<input type="hidden" name="isHoliday" value="${attend.isHoliday}"/>
					<input type="hidden" name="enable" value="${attend.enable}"/>
					</td>
						<td width="90"><fmt:formatDate value="${attend.stime}" pattern="hh:mm:ss"/></td>
					<c:if test="${attend.enable==true}">
					<td width="90"><a style="text-decoration:none" class="ml-5" onClick="attend(this)" href="javascript:;" title="打卡"><i class="Hui-iconfont">&#xe6df;</i></a> </td>
					</c:if>
					<td width="90">备注:<input type="text" name="remark" value="${attend.remark}"/></td>
					<c:if test="${attend.enable==false}">
					<td width="90">不可打卡</td>
					</c:if>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		</form>
	</div>
</div>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>

<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
function attend(btn) {
	var pswd=prompt("请输入密码:")
	//将非空的密码值传入数据库，查看是否与用户信息匹配
	if(pswd!=null){
		$.ajax({
			   type: "POST",
			   url: "../User/upwdCheck",
			   data: "upwd="+pswd,
			   dataType: "text",
			   success: function(msg){
			     if(msg=="ok"){
			    	 //密码验证通过
			    	 	var tr=btn.parentElement.parentElement;
			    		var userIda=tr.firstElementChild.firstElementChild;
			    		var userId=userIda.value;
			    		var registerId=userIda.nextElementSibling.nextElementSibling.value;
			    		var remark=tr.lastElementChild.firstElementChild.value;
			    		$.ajax({
			    			   type: "POST",
			    			   url: "addUserAttend",
			    			   data: "userId="+userId+"&registerId="+registerId+"&remark="+remark,
			    			   dataType: "text",
			    			   success: function(message){
			    			     alert(message);
			    			   }
			    			});
			     }else{
			    	 alert(msg);
			     }
			  }
		});
	}
}

</script>
</body>
</html>