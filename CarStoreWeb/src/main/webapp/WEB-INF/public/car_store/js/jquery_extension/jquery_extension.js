$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	if(results){
		if(results.length > 0){
			return results[1] || 0;
		}else{
			return "";
		}
	}else{
		return "";
	}	
}

$.urlParamExists = function(name, url){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(url);
	if(results){
		if(results.length > 0){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}	
}

/*
* url 目标url(http://www.phpernote.com/)
* arg 需要替换的参数名称
* arg_val 替换后的参数的值
* return url 参数替换后的url
*/
$.changeURLArg = function changeURLArg(url,arg,arg_val){
    var pattern=arg+'=([^&]*)';
    var replaceText=arg+'='+arg_val;
    if(url.match(pattern)){
        var tmp='/('+ arg+'=)([^&]*)/gi';
        tmp=url.replace(eval(tmp),replaceText);
        return tmp;
    }else{
        if(url.match('[\?]')){
            return url+'&'+replaceText;
        }else{
            return url+'?'+replaceText;
        }
    }
    return url+'\n'+arg+'\n'+arg_val;
}

$.logout = function(){
	var stateObj = { sessionId: "" };
	history.replaceState(stateObj, "", "");
	$(location).attr('href',$.changeURLArg($(location).attr('href'),"sessionId",""));
	/*location.reload();*/
}


