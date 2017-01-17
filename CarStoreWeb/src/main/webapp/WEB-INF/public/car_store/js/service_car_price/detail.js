$(function() 
{
	$("#searchServicePriceForm").submit(function(event) 
	{
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
				carTypeId : $("#carTypeId").val(),
				serviceId : $("#serviceId").val()
				};
				
			var serviceCarPriceSearchOption = {
					type : 'POST',
					url : '/CarStoreWeb/serviceCarPrice/action/search?sessionId='+sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								Transparency.render(document.getElementById('displayServicePrice'), data.result);
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
				$.ajax(serviceCarPriceSearchOption);
		}else{
			alert("user did not login.");
		}
			
	});

});