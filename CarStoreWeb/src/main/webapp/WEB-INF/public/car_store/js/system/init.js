$(function() {
	
	//beautify the file select input
	$("#fileAjaxUpload").change(function(){
		var arr = $(this).val().split("\\");
		if(arr){
			var fileName = arr[arr.length-1];
			$("#fileAjaxUploadLabel").text(fileName);
		}
	});
	
	$("#submitAjaxFile").click(function() {
		
		$.ajaxFileUpload({
			url : '/CarStoreWeb/system/init', // 需要链接到服务器地址
			secureuri : false,
			fileElementId : 'fileAjaxUpload', // 文件选择框的id属性
			dataType : 'json', // 服务器返回的格式，可以是json
			type: 'post',
			data : {},
			success : function(data, status) // 相当于java中try语句块的用法
			{
				if(data){
					if(data.success){
						alert("系统初始化完毕！");
					}else{
						alert("系统初始化失败！  " + data.result);
					}
				};
			},
			error : function(data, status, e) // 相当于java中catch语句块的用法
			{
			}
		});
	});

});