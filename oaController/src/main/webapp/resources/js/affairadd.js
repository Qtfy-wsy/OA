$(document).ready(function(){
	
	$.ajax({
		type: "POST",
        dataType: "json",
        url: "../affairmodule/selectdp1",
        //data: ,
        success: function (data) {
        	$("#dp1").html(data.nickName);
        	$("#dp1").attr("data",data.userId);
        	selectFlow();
        }
	})
	
	$("#dp2").focus(function(){
		$("#dp2").empty();
		$.ajax({
			type: "POST",
	        dataType: "json",
	        url: "../affairmodule/selectdp2",
	        //data:,
	        success: function (data) {
	        	$.each(data,function(k,v){
	        		var option=$("<option></option>");
	        		option.val(v.userId);
	        		option.html(v.departmentName);
	        		$("#dp2").append(option);
	        	})
	        }
		})
	})
	
	$("#dp2").change(function(){
		var leaderId = $("#dp2").val();
		$(".dp3").empty();
		$.ajax({
			type: "POST",
	        dataType: "json",
	        url: "../affairmodule/selectdp3",
	        data:{"leaderId":leaderId},
	        success: function (data) {
	        	$.each(data,function(k,v){
	        		var a=$("<a></a>");
	        		a.attr("data",v.userId);
	        		a.html(v.nickName);
	        		$(".dp3").append(a);
	        	})
	        	selectFlow();
	        }
		})
	})
	
	//添加控件
	$("#btn").click(function(){
		//基础控件的值++
		var cols = $("input[name='cols']").val();
		cols++;
		$("input[name='cols']").val(cols);
		
		//组合内容，显示一套新的
		var str = '<div>';
    	str += '栏目名称：<input name="modelItemName'+cols+'" type="text" />';
    	str += '栏目类型：<select name="modelItemType'+cols+'">';
    	str += '<option value="1">文本框</option>';
    	str += '<option value="2">日期框</option>';
    	str += '<option value="3">下拉列表</option>';
    	str += '<option value="4">单选</option>';
    	str += '<option value="5">多选</option>';
    	str += '<option value="6">上传</option>';
    	str += '<option value="7">多行文本</option></select>';
    	str += '栏目控件参数：<input name="modelItemOption'+cols+'" type="text" />'; 
    	//后面多出来的按钮，网页中已经不再查找了，单独调用方法
    	str += '<input id="del" type="button" value="删除" style="margin-left:20px;" onclick="delcol(this)" />';
    	str += '</div>';
		
		//显示出来
    	$("#dv1").append(str);    	
	});
	
	function selectFlow(){
		//流程连选择
		$("#lcl a").click(function(){
			//变量，一个新的字符串
			var newstr = "-1";
			var newstr2 = "发起流程";
			
			//第一步：找到隐藏文本框的值
			var str = $("input[name='chain']").val();
			var str2 = $("#fq").html();
			//第二步：切割成数组，按照逗号
			var arr = str.split(",");
			var arr2 = str2.split("→");
			
			//控制变量，默认需要追加的
			var flag=true;
			
			//第三步，循环遍历.进行判断，是否需要组合这个内容
			//索引从1开始，跳过-1
			for(var i=1; i<arr.length; i++){
				if(arr[i]==$(this).attr("data")){
					//不要追加了
					flag=false;
					$(this).css({"background":"#ffffff"});
					//跳过
					continue;
				}
				//组合新的字符串
				newstr += ","+arr[i];
				newstr2 += "→"+arr2[i];
			}
			if(flag){
				newstr += ","+$(this).attr("data");
				newstr2 += "→"+$(this).html();
				$(this).css({"background":"#cccccc"});
			}
			
			$("input[name='chain']").val(newstr);
			$("#fq").html(newstr2);
		});
		
	}
	
});


//独立函数
function delcol(dom){
	//js的dom对象，变成jquery对象
	$(dom).parent().remove();
}


