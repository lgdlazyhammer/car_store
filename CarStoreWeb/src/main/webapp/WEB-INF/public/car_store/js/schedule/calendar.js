$(function() 
{
	$('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1,
		minView: 2,
        format: 'yyyy-mm-dd'
        /*format: 'yyyy-mm-dd hh:ii:ss'*/
    });
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	$('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
	
	$("#scheduleCalendarForm").submit(function(event) 
	{
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
				timeStart : $("#scheduleCalendarTime").val()?$("#scheduleCalendarTime").val()+" 00:00:00":"",
				timeEnd : $("#scheduleCalendarTime").val()?$("#scheduleCalendarTime").val()+" 23:59:59":""
				};
				
			var scheduleCalendarOption = {
					type : 'POST',
					url : '/CarStoreWeb/schedule/action/management/calendar?sessionId='+sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								var calenderTable = data.result;
								var calenderTableDisplay = "";
								var calenderTableLine = "";
								for(var i=0;i<calenderTable.length;i++){
									calenderTableLine += "<tr>";
									for(var j=0;j<calenderTable[i].length;j++){
										if(j==0){
											calenderTableLine += "<td>"+6*i+"到"+(6*(i+1)-1)+"小时预约数</td>";
										}
										calenderTableLine += "<td>"+calenderTable[i][j]+"</td>";
									}
									calenderTableLine += "</tr>";
									calenderTableDisplay += calenderTableLine;
									calenderTableLine = "";
								}
								
								$("#scheduleCalendarTable").html("");
								$("#scheduleCalendarTable").html(calenderTableDisplay);
							}else{
								alert(data.result);
								$("#scheduleCalendarTable").html("");
								$("#scheduleCalendarTable").html("没有预约！");
							}
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
					},
					timeout : function(data) {
					}
				};
				// initialize the page
				$.ajax(scheduleCalendarOption);
		}else{
			alert("user did not login.");
		}
			
	});

});