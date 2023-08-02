var jQ = $;

//jQuery ajax全局配置,session过期跳转到登录页面
$.ajaxSetup({
    complete: function(xhr, status) {
        if(xhr.status === 401){
        	top.location.href = '/sg-iot/portal/rest/login';
        }else if(xhr.status === 403){
        	showWarning(xhr.responseText);
        	return false;
        }
    }
});


/**
 * 初始化下拉框数据
 * <p>
 * 默认第一行为"请选择"
 * 
 * @param container 	下拉框id、下拉框dom元素或下拉框jQuery对象
 * @param datas 		服务端返回的下拉框数据对象，格式如：{"01":"停止", "02":"运行", "03":"暂停"}
 * @param initTitle		string：自定义首行option内容，boolean：是否显示默认首行信息
 */
function initSelect(container, datas, initTitle) {
	var $select = container2JQuery(container);

	var text;
	if(initTitle === false || initTitle === '') {
		text = '';
	} else if(!initTitle || initTitle === true){
		text = '<option value="">请选择</option>';
	} else {
		text = initTitle;
	}

	if(isArray(datas)){
		for(var i = 0; i < datas.length; i++){
			text += '<option value="' + datas[i]["value"] + '">' + datas[i]["name"] + '</option>'
		}
	} else {
		for (var key in datas) {
			if (datas.hasOwnProperty(key)) {
				text += '<option value="' + key + '">' + datas[key] + '</option>'
			}
		}
	}
	$select.html(text);
}

/**
 * URL弹窗，如果不指定宽高，则默认iframe全屏展示
 * 
 * @param url		url地址
 * @param title 	标题
 * @param width 	宽（数值）
 * @param height 	高（数值）
 * 
 * @return openWindowId	 layer id，可使用"layer.close(openWindowId);"关闭
 */
function showUrl(url, title, width, height){
	var option = {
		type: 2,
		title: title,
		shadeClose: false,
		content: url
	};
	var full = !width || !height; 
	if(!full){
		option.area = [width+'px', height+'px'];
	}
    var openWindowId = layer.open(option);
    if(full){
    	layer.full(openWindowId);
    }
    return openWindowId;
}


/**
 * DIV弹窗
 * 
 * @param div 		容器ID
 * @param title 	标题
 * @param width 	宽
 * @param height 	高
 * 
 * @return openWindowId	layer id，可使用"layer.close(openWindowId);"关闭
 */
function showDiv(div, title, width, height){
	var option = {
		type: 1,
		title: title,
		shadeClose: false,
		content: $("#"+div)
	};
	var full = !width || !height; 
	if(!full){
		option.area = [width+'px', height+'px'];
	}
    var openWindowId = layer.open(option);
    if(full){
    	layer.full(openWindowId);
    }
    return openWindowId;
}

/**
 * 告警弹窗
 * 
 * @param msg 信息
 */
function showWarning(result, msg){
	var msg;
	if(arguments.length == 1){
		msg = result;
	} else if(arguments.length == 2){
		msg = result && result.ok === false && result.msg || "操作失败！";
	}
	return window['layer'] && layer.msg(msg, {icon: 5}) || alert(msg);
}

/**
 * 信息弹窗
 * 
 * @param msg 信息
 */
function showInfo(msg){
	return layer.msg(msg);
}

/**
 * 加载动画，避免重复提交
 * 
 * @param timeout　超时时间（ｓ）
 * @returns 标识，用以关闭
 */
function showLoading(timeout){
	return layer.load(2, {time: (timeout | 10) * 000});
}


/**
 * 关闭当前layer窗口
 */
function closeLayer(){
	parent.layer.close(parent.layer.getFrameIndex(window.name));
}

/**
 * 获取当前URL中指定参数值，没有则获取名称为"id"的参数值
 * 
 * @param name 参数名
 * @return 参数值或false
 */
function getUrlParameter(name) {
	var obj = window['location'];
	var search = obj.search;
	//name参数为空时返回url第一个参数
	if(!name){
		return search.split("=")[1]
	}
	var query = search.substring(1);
	var args = query.split("&");
	if(!args){
		return null;
	}
	for ( var i = 0; i < args.length; i++) {
		var pair = args[i].split("=");
		if (pair[0] === name) {
			return pair[1];
		}
	}
}


/**
 * 将form表单的数据转换成JSON对象
 *
 * @param container 表单id、表单dom元素或表单jQuery对象
 * @param target 目标对象
 * @returns 对象
 */
function form2Object(container, target) {
	var $form = form2jQuery(container);

	var array = $form.serializeArray();
	var result = target || {};
	array.forEach(function(obj) {
		if (obj.value !== "") {
			result[obj.name] = obj.value;
		}
	});
	
	//针对bootstrap-select多选项的处理
	$form.find(".selectpicker").each(function(i, ele){
		var value = $(ele).val();
		if(value){
			result[ele.name] = value.join(",");
		}
	});
	
	return result;
}

/**
 * 将表单转换为FormData对象，用以实现携带文件的ajax上传
 * 
 * @param container	 表单id、表单dom元素或表单jQuery对象
 * @returns FormData对象
 */
function form2FormData(container){
	var form = container2Form(container);
	var formData = new FormData(form);
	
	
	$(form).find(".selectpicker").each(function(i, ele){
		var value = $(ele).val();
		if(value){
			formData.set(ele.name, value.join(","));
		}
	});
	return formData;
}

function container2Element(){
	
}

function container2Form(container){
	if(!container){
		return document.forms[0];
	}
	var form;
	if(isString(container)){
		form = document.getElementById(container);
	} else if(isElement(container)){
		form = container;
	} else if(isJQuery(container)){
		return container[0];
	}
	return document.forms[0];
}

function container2JQuery(container){
	var $container;
	if (isString(container)) {
		return $("#" + container);
	} else if (isJQuery(container)) {
		return container;
	} else if(isElement(container)){
		return $(container);
	}
	return null;
}


/**
 * 将ajax请求的数据填充至表单，要求表单name与data的key一致
 * 
 * @param data		一般为服务端响应的待编辑数据
 * @param formId	表单id，没有则使用第一个变量  
 */
function renderFormData(data, formId) {
	var form = formId ? document.getElementById(formId) : document.forms[0];
	form.forEach(function(ele) {
		for ( var e in data) {
			if (data.hasOwnProperty(e) && ele.name === e) {
				//针对selectpicker的特殊处理
				if (ele.className.split(/\s+/).indexOf("selectpicker") !== -1) {
					$(ele).selectpicker('val', data[e].split(","));
				} else {
					ele.value = data[e];
				}
			}
		}
	});
}

/**
 * 表单重置
 * 
 * @param container	 表单id、表单dom元素或表单jQuery对象
 */
function resetForm(container){
	var $form = form2jQuery(container);
	$form.find('input:text, input:hidden, input:password, input:file, select, textarea').val('');
    $form.find('input:radio, input:checkbox').removeAttr('checked').removeAttr('selected');
}

/**
 * 将表单转换为jQuery对象
 * 
 * @param container	 表单id、表单dom元素或表单jQuery对象
 * @returns form表单的jQury对象
 */
function form2jQuery(container){
	var $form;
	if (!container) {
		$form = $(document.forms[0]);
	} else if (isString(container)) {
		$form = $("#" + container);
	} else if (isJQuery(container)) {
		$form = container;
	} else {
		$form = $(container);
	}
	return $form;
}

/**
 * post形式下载文件。将请求参数封装在临时post表单中，也可用于excel导出
 * 		
 * @param url 			服务端下载地址
 * @param formData 		表单数据(可选)
 */
function download(url, data, pageNumber, pageSize) {
	//定义一个form表单
	var downloadForm = $("<form id='downloadForm' style='display:none' target='' method='post'>");
	downloadForm.attr("action", url);
	var input;
	if(data){
		for(var name in data){
			if(data.hasOwnProperty(name)){
				input = $("<input>");
				input.attr("type", "hidden");
				input.attr("name", name);
				input.attr("value", data[name]);
				downloadForm.append(input);
			}
		}
	}
	$("body").append(downloadForm);
	downloadForm.submit();
	$("#downloadForm").remove();
}

/**
 * 验证文件是否合法，并给出提示
 *
 * @param fileId 待检测文件id
 * @param allowTypes 允许的扩展名，数组或逗号分隔的字符串
 * @param maxSize 允许的文件体积大小，单位MB
 * @returns 合法返回true，否则弹窗告警并返回false
 */
function validateFile(fileId, allowTypes, maxSize) {
	var file = document.getElementById(fileId);
	//附件不存在
	if (file === null || file.files.length === 0) {
		return true;
	}

	file = file.files[0];
	var name = file.name;
	var fileType = name.substr(name.lastIndexOf(".") + 1).toLowerCase();

	if (typeof allowTypes == 'string' && allowTypes.constructor === String) {
		allowTypes = allowTypes.split(",");
	}
	var ok = false;
	for(var i in allowTypes){
		if(fileType === allowTypes[i].toLowerCase()){
			ok = true;
			break;
		}
	}

	if(ok === false){
		showWarning("不支持的文件类型！");
		return false;
	}

	// 验证文件体积合法性
	var size = Math.round(file.size / 1024 / 1024 * 100) / 100;
	if(size >= maxSize){
		showWarning("文件大小不能超过"+maxSize+"MB");
		return false;
	}

	return true;
}

/**
 * 根据元素的ps属性(ISC受控资源的业务编码)值以及用户的所有功能资源业务编码列表来判断元素对用户是否可见
 * 
 * @param hide true表示隐藏没权限访问的元素，false表示显示有权限访问的元素。默认为true
 */
function handleForPermission(hide){
	if(arguments[0] === undefined){
		hide = true;
	}
	
	//页面有ps属性的元素
	var nodes = $("*[ps]");
	if(nodes.length === 0){
		return;
	}
	//用户的所有功能资源业务编码列表
	var resources = top.resources;
	for(var i = 0 ; i < nodes.length; i++){
		var $node = $(nodes[i]);
		var value = $node.attr("ps");
		if(!value){
			continue;
		}
		if(hide === true){
			var has = false;
			for(var j = 0 ; j < resources.length; j++){
				if(resources[j] === value){
					has = true;
					break;
				}
			}
			if(!has){
				$node.hide();
			}
		} else {
			for(var j = 0 ; j < resources.length; j++){
				if(resources[j] === value){
					$node.show();
					break;
				}
			}
		}
	}
}


/**
 * 是否是document元素
 * 
 * @param obj 待检测对象
 * @returns {Boolean} 是返回true，否则false
 */
function isElement(obj) {
	if (typeof HTMLElement === 'object') {
		return obj instanceof HTMLElement;
	}
	if (obj && typeof obj === 'object'
			&& (obj.nodeType === 1 || obj.nodeType === 9)
			&& typeof obj.nodeName === 'string') {
		return true;
	}
	return false
}

/**
 * 检测是否是字符串元素
 * 
 * @param obj 待检测对象
 * @returns {Boolean} 是返回true，否则false
 */
function isString(obj){
	return Object.prototype.toString.call(obj) === '[object String]';
}

/**
 * 检测是否是数组对象
 * 
 * @param obj 待检测对象
 * @returns {Boolean} 是返回true，否则false
 */
function isArray(obj){
	return Object.prototype.toString.call(obj) === '[object Array]';
}

/**
 * 检测是否是jQuery对象
 * 
 * @param obj 待检测对象
 * @returns {Boolean} 是返回true，否则false
 */
function isJQuery(obj){
	return obj instanceof jQuery;
}

/**
 * 跳转到指定URL
 * 
 * @param url	目标URL
 */
function toUrl(url){
	var obj =  window['location'];
	obj["href"] = url;
}

function timestampFormat(timestamp, pattern) {
	if(!timestamp || isNaN(timestamp)){
		return "";
	}
	var datetime = new Date(timestamp);
	var year =  datetime.getFullYear();
	var month = '0' + (datetime.getMonth() + 1);
	var day = '0' + datetime.getDate();
	var hour = '0' + datetime.getHours();
	var minute = '0' + datetime.getMinutes();
	var second = '0' + datetime.getSeconds();
	if(!pattern){
		return '';
	}
	if(pattern.length === 19 || pattern === 'datetime'){
		return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2) + ":" + second.substr(-2);
	} else if(pattern.length === 10 || pattern === 'date'){
		return year + "-" + month.substr(-2) + "-" + day.substr(-2);
	}
	return '';	
};
