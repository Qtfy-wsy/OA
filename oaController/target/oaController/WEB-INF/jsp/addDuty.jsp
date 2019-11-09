<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加班次</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="dutyAdd" action="##" method="post" onsubmit="return false">
	<div class="row cl">
		<input type="hidden" name="permissionId" value="${permissionId }" />
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班次名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="请填写班次名称" id="dutyName" name="dutyName" style="width:150px;" onblur="enable(this)"/><span id="info"></span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">公休日：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="week" size="7" multiple="multiple" >
				<option value="0">星期日</option>
				<option value="1">星期一</option>
				<option value="2">星期二</option>
				<option value="3">星期三</option>
				<option value="4">星期四</option>
				<option value="5">星期五</option>
				<option value="6">星期六</option>
			</select>
			</span> </div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第一次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime1" size="1" >
			</select>
			</span> 
			<span class="radio-box">上班卡<input type="radio"  name="dutyType1" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType1" value="2" /></span>
			</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第二次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime2" size="1" >
				
			</select>
			</span> 
			<span class="radio-box">上班卡<input type="radio"  name="dutyType2" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType2" value="2" /></span>
			</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第三次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime3" size="1" >
			</select>
			</span>
			<span class="radio-box">上班卡<input type="radio"  name="dutyType3" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType3" value="2" /></span>
			 </div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第四次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime4" size="1" >
				
			</select>
			</span> 
			<span class="radio-box">上班卡<input type="radio"  name="dutyType4" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType4" value="2" /></span>
			</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第五次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime5" size="1" >
				
			</select>
			</span> 
			<span class="radio-box">上班卡<input type="radio"  name="dutyType5" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType5" value="2" /></span>
			</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">第六次打卡时间：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select selectTime" name="dutyTime6" size="1" >				
			</select>
			</span> 
			<span class="radio-box">上班卡<input type="radio"  name="dutyType6" value="1" checked/></span>
			<span class="radio-box">下班卡<input type="radio"  name="dutyType6" value="2" /></span>
			</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="sub()"/>
			<input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;取消&nbsp;&nbsp;"/>
		</div>
	</div>
	</form>
</article>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
var sub_enable=false;
var arr_time=new Array("00:00:00","00:30:00","01:00:00","01:30:00","02:00:00","02:30:00","03:00:00","3:30:00","04:00:00","04:30:00","05:00:00","05:30:00","06:00:00","06:30:00","07:00:00","07:30:00","08:00:00","08:30:00","09:00:00","09:30:00","10:00:00","10:30:00","11:00:00","11:30:00","12:00:00","12:30:00","13:00:00","13:30:00","14:00:00","14:30:00","15:00:00","15:30:00","16:00:00","16:30:00","17:00:00","17:30:00","18:00:00","18:30:00","19:00:00","19:30:00","20:00:00","20:30:00","21:00:00","21:30:00","22:00:00","22:30:00","23:00:00","23:30:00","24:00:00");
var select_arr=document.getElementsByClassName("selectTime");
function loadTime() {
	for(var i=0;i<select_arr.length;i++){
		select_arr[i].appendChild(new Option("缺省",""));
		for(var j=0;j<arr_time.length;j++){
			select_arr[i].appendChild(new Option(arr_time[j],arr_time[j]));
		}
	}
}
window.onload=loadTime();
var message=document.getElementById("info");
function enable(name) {
	var name_value=name.value.trim();
	if(name_value.length!=0){
		//将用户名通过ajax传去数据库检查名称是否重复
		$.ajax({
            type: "POST",//方法类型
            url: "checkDutyName",
            data: "dutyName="+name_value,
            dataType: "text",//预期服务器返回的数据类型
            success: function (result) {
            	message.innerHTML=result;
            	if(result=="ok"){
            		sub_enable=true;
            	}else{sub_enable=false;}
            },
            error : function() {
                alert("异常！");
            }
        });
	}else{
		sub_enable=false;
		message.innerHTML="名称不能为空!";
	}
}
function sub() {
	if(sub_enable){
		$.ajax({
            type: "POST",//方法类型
            dataType: "text",//预期服务器返回的数据类型
            url: "addDutyEnd" ,//url
            data: $('#dutyAdd').serialize(),
            success: function (result) {
            	sub_enable=false;
            	alert(result);
            },
            error : function() {
            	sub_enable=false;
                alert("系统异常！");
            }
        });
	}
}	
	
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>