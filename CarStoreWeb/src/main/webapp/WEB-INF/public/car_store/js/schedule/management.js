$(function() 
{
	$("#scheduleManagementForm").submit(function(event) 
	{
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
				userName : $("#userName").val(),
				carTypeId : $("#managementCarType").val(),
				serviceId : $("#managementService").val(),
				timeStart : $("#scheduleStartTime").val()?$("#scheduleStartTime").val()+":00":"",
				timeEnd : $("#scheduleEndTime").val()?$("#scheduleEndTime").val()+":00":""
				};
				
			var userRegisterOption = {
					type : 'POST',
					url : '/CarStoreWeb/schedule/action/management/search?sessionId='+sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								$("#displayUsers").removeClass("hidden");
								Transparency.render(document.getElementById('displayUsers'), data.result);
								$(".schedule-management-item").dblclick(function(){
									/*get the schedule id*/
									var scheduleId = $(this).children("span").eq(0).text();
									/*$(location).attr('href','/CarStoreWeb/schedule/modify?userId=' + sessionId +"&scheduleId=" + scheduleId);*/
									$("#toModifyPageForm").children("input").eq(0).val(sessionId);
									$("#toModifyPageForm").children("input").eq(1).val(scheduleId);
									$("#toModifyPageForm").submit();
								});
							}else{
								alert(data.result);
							}
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
					},
					timeout : function(data) {
					}
				};
				// initialize the page
				$.ajax(userRegisterOption);
		}else{
			alert("user did not login.");
		}
			
	});

});