$(document).ready(function(){
    			
		$("#btn").click(function(){
			//提取网页中的文本与控件的数据，
			//提交方式： ajax，隐藏文本框提交
			
			var str = '<table id="table" border="1">';
			$("tr").each(function(index,dom){
				str+='<tr>';
				 //第一个td
				 str += '<td>'+$(dom).children("td").first().html()+'</td>';
				 
				 //第二个td                                          
				 var x = $(dom).children("td").last().attr("data");
				 if(x=="0"){
					 str += '<td>'+$(dom).children("td").last().html()+'</td>';
				 }
				 if(x=="1" || x=="2"||x=="6"){//文本 日期框 上传
					 str += '<td>'+$(dom).children("td").last().find("input").val()+'</td>';
				 }
				 if(x=="3"){
					 str += '<td>'+$(dom).children("td").last().find("select").val()+'</td>';
				 }
				 if(x=="4"){//单选
					 $(dom).children("td").last().find("input").each(function(i,d){
						 if($(d).attr("checked")){
							 str += '<td>'+$(d).val()+'</td>';
						 }    							 
					 });    						 
				 }
			    if(x=="5"){//多选
					 str+='<td>';
					  $(dom).children("td").last().find("input").each(function(i,d){
						 if($(d).attr("checked")){
							 str+=$(d).val()+',';
						 }    							 
					 }); 
					 //去掉最后一个， 
					 str=str.substr(0,str.length-1);
					 str+='</td>';
				 } 
				 if(x=="7"){//多行文本
					 str += '<td>'+$(dom).children("td").last().find("textarea").val()+'</td>';
				 } 
				 
				 str+='</tr>';
			});    				
			str +='</table>';
			$("input[name='content']").val(str);
			
			 //提交表单
			 $.ajax({
		                type: "POST",
		                //dataType: "json",
		                url: "../affair/save" ,//url
		                data: $('#form1').serialize(),
		                success: function (data) {
		                    if (data=="success") {
		                        alert("公文提交成功");
		                        window.location.href = "forword";
		                    };
		                },
		                error : function() {
		                    alert("公文提交异常！");
		                    window.location.href = "forword";
		                }
		            });
			
		});
    			
});
    	