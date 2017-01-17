$(function() {

	initPagePersonImg();

	var sessionId = $.urlParam('sessionId');
	if (!sessionId) {
		if (history.state) {
			if (history.state.sessionId.length > 30) {
				sessionId = history.state.sessionId;
			}
		}
	}

	$(".user-car-modify").click(function() {
		if (sessionId) {
			var carId = $(this).attr("title");
			$("#userCarModifyForm").children().eq(0).val(carId);
			$("#userCarModifyForm").children().eq(1).val(sessionId);
			$("#userCarModifyForm").submit();
		} else {
			alert("用户没有登陆！");
		}
	});

	$(".user-car-delete").click(function() {
		if (sessionId) {
			var carId = $(this).attr("title");
			deleteUserCar(carId);
		} else {
			alert("用户没有登陆！");
		}
	});

	/* beautify the file select input */
	$("#changePersonImage").change(function() {
		if (sessionId) {
			$.ajaxFileUpload({
				url : '/CarStoreWeb/fileService/fileUploadSingle', // 需要链接到服务器地址
				secureuri : false,
				fileElementId : 'changePersonImage', // 文件选择框的id属性
				dataType : 'json', // 服务器返回的格式，可以是json
				type : 'post',
				data : {
					secureLevel : 2
				},
				success : function(data, status) // 相当于java中try语句块的用法
				{
					if (data.result) {
						if (data.result) {
							updateUserPic(data.result);
						}
					}
					;
				},
				error : function(data, status, e) // 相当于java中catch语句块的用法
				{
				}
			});
		} else {
			alert("用户没有登陆！");
		}
	});

	/* update user picture */
	function updateUserPic(picId) {

		var param = {
			id : sessionId,
			picId : picId
		};

		var updateUserPicOption = {
			type : 'POST',
			url : '/CarStoreWeb/user/action/updatePic?sessionId=' + sessionId,
			data : {
				ajaxData : JSON.stringify(param)
			},
			success : function(data) {
				if (data) {
					if (data.success) {
						/* change the page picture */
						getPicRefUrl(data.result);
					} else {
						alert(data);
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
			timeout : function(data) {
			}
		};
		// initialize the page
		$.ajax(updateUserPicOption);
	}

	function getPicRefUrl(fileId) {
		var getResourceOwnerAllOption = {
			type : 'POST',
			url : '/CarStoreWeb/fileService/fileDownloadSingle',
			data : {
				id : fileId
			},
			success : function(data) {
				if (data) {
					$("#userInfoPic").attr("src",
							"/CarStoreWeb/" + data.result.refUrl);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("get picture failed.");
			},
			timeout : function(data) {
			}
		};
		// initialize the page
		$.ajax(getResourceOwnerAllOption);
	}

	function initPagePersonImg() {

		var initPersonImgId = $("#userPicIdFromInit").val();

		if (initPersonImgId) {
			getPicRefUrl(initPersonImgId);
		}
	}

	/* delete user car */
	function deleteUserCar(carId) {

		var param = {
			id : carId
		};

		var deleteUserCarOption = {
			type : 'POST',
			url : '/CarStoreWeb/car/action/delete?sessionId=' + sessionId,
			data : {
				ajaxData : JSON.stringify(param)
			},
			success : function(data) {
				if (data) {
					if (data.success) {
						/* change the page picture */
						location.reload();
					} else {
						alert(data);
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
			timeout : function(data) {
			}
		};
		// initialize the page
		$.ajax(deleteUserCarOption);
	}

});