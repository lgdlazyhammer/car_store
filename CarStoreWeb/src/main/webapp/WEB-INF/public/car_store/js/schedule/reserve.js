$(function() 
{
	$("#userPreorderForm").submit(function(event) 
	{
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
				userId : sessionId,
				carId : $("#preorderCarType").val(),
				serviceId : $("#preorderService").val(),
				timeStart : $("#scheduleStartTime").val()?$("#scheduleStartTime").val()+":00":"",
				timeEnd : $("#scheduleEndTime").val()?$("#scheduleEndTime").val()+":00":""
				};
				
			var userRegisterOption = {
					type : 'POST',
					url : '/CarStoreWeb/schedule/action/reserve?sessionId='+sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								/*$.cookie('userId', data.result);
								$(location).attr('href','/CarStoreWeb/car/register?userId=' + data.result);*/
								$("#scheduleReserveSuccess").removeClass("hidden");
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