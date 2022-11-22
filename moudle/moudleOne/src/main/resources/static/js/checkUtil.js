/**
 * 所有input框去除历史记录
 */
$(function(){
	checkSession();
	$("input[type='text']").each(function() {
	    $(this).removeAttr("autocomplete");
	    $(this).attr("autocomplete","off");
	    });
	$("input[class='file-hidden']").each(function() {
	    $(this).attr("type","file");
	    });
});
/**
 * 验证session是否失效，如果失效，则退出重新登录
 */
function checkSession(){
	$(document).ajaxComplete(function(event, xhr, settings) {
		var a = xhr.getResponseHeader("sessionstate");
	    if(xhr.getResponseHeader("sessionstate")=="timeout"){  
	        if(xhr.getResponseHeader("redirecturl")){
//	            window.top.location.replace(xhr.getResponseHeader("redirecturl"));
	        	var obj =  window.top['location'];
	        	obj["replace"] = xhr.getResponseHeader("redirecturl");
	        }
	    }  
	});
}
function checkSessionNoAjax(url){
	/**
	* 测试session是否失效
	*/
	$.ajax({
		type: 'HEAD', // 获取头信息，type=HEAD即可
		url : url,
		complete: function(xhr,data ){
			if(xhr.getResponseHeader("sessionstate")=="timeout"){
				window.top.location.href="/mscClient/iscintegrate/signout";
			}else{
				//正常提交
				toUrl(url);
			}
		}
	});
}
/**
 * 验证form中各元素内容
 * @param $wrap
 * @returns {Boolean}
 */
function checkForm($wrap){
	//去掉验证错误信息提示样式
	removeCheckStyle($wrap);
//	var result;
	var $nodes = $wrap.find("[chk_text]:not([disabled])");
	var flag = true;
	var hint="";
	for(var i = 0; i < $nodes.length; i++){
		// 循环每个待检元素
		$node = $nodes.eq(i);
		var chk_type = $node.attr("chk_type");
		var max_length= $node.attr("max_length");
		var must_fill= $node.attr("must_fill");
		var chk_text= $node.attr("chk_text");
		var file_type= $node.attr("file_type");
		var val = '';
		var tagName = $node[0].tagName;
		if(tagName=='SPAN'){
			val = $node.text();
		}else{
			val =$node.val();
		}
		//验证非空
		if(must_fill!=undefined && must_fill=="true"){
			if(isEmpty(val)){
				flag = false;
				hint = "'"+chk_text+"'不能为空！";
//				style="border-color: red"
//				$('#'+$node.attr("id")+"Hint").html(hint);
				addCheckFalseStyle($node,hint);
				break;
			}
		}
		//验证格式
		if(chk_type!=undefined && !isEmpty(chk_type)){
			if(isEmpty(val)){
		        continue;//遇见不是必填项的越过进行下一个的验证
		      }
			hint = checkText(chk_type,val,chk_text);
			if(!isEmpty(hint)){
				flag = false;
				addCheckFalseStyle($node,hint);
				break;
			}
		}
		//是否超过最大长度
		if(max_length!=undefined && !isEmpty(max_length) && isSuperLong(val,max_length)){
			flag = false;
			hint = "'"+chk_text+"'超出了最大长度为'"+max_length+"'字节长度限制！"; 
			addCheckFalseStyle($node,hint);
			break;
		}
		//验证文件上传格式
		if(file_type!=undefined && !isEmpty(file_type)){
			if(!checkFileType(file_type,val)){
				flag = false;
//				hint = "'"+chk_text+"'格式不正确，只能上传格式为‘"+file_type+"’的文件！"; 
				hint = "'"+chk_text+"'格式不正确，只能上传格式为'"+file_type+"'的文件！"; 
				addCheckFalseStyle($node,hint);
				break;
			}else{
				if(!checkFileSize($node[0],100)){
					flag = false;
					hint = "'"+chk_text+"'文件大小不能超过100M！"; 
					addCheckFalseStyle($node,hint);
					break;
				}
			}
		}
	}
	return flag;
}
/**
 * 因保存时无需验证必填性，故只需要验证单个对象
 */
function validFileForOne($node,$styleNode){
	var hint="";
	var chk_text= $node.attr("chk_text");
	var file_type= $node.attr("file_type");
	var val="";
	val =$node.val();
	if(!checkFileType(file_type,val)){
		flag = false;
		hint = "'"+chk_text+"'格式不正确！";
		addCheckFalseStyle($styleNode,hint);
		return false;
	}else{
		if(!checkFileSize($node[0],100)){
			hint = "'"+chk_text+"'文件大小不能超过100M！"; 
			addCheckFalseStyle($styleNode,hint);
			return false;
		}
	}
	return true;
}
/**
 * 保存时自定义验证
 * @param $node 对象
 * @param $nodeVal 对象的值
 * @param length 限定长度
 * @param aler 提示前缀
 * @param checkxt 验证类型
 * @returns {Boolean} true 通过验证 false 不通过验证
 */
function validLongAndText($node,$nodeVal,length,aler,checkxt){
	if(isEmpty($nodeVal)){
        return true;
    }
	if(isSuperLong($nodeVal,length)){
		addCheckFalseStyle($node,aler+'长度超长，最大长度为'+length+'请重新输入！'); return false;
	}else if(checkText(checkxt,$nodeVal,aler)!=null){
		addCheckFalseStyle($node,checkText(checkxt,$nodeVal,aler)); return false;
	}else{
		return true;
	}
}
/**
 * 验证非空
 * 
 * @param str
 * @returns
 */
function isEmpty(str) {
	if (str == undefined || str == null || str == '') {
		return true
	}
	return false;
}
/**
 * 验证字符串内容
 * @param type 验证类型
 * @param text 验证字符串内容
 * @param str 验证内容名称
 * @returns
 */
function checkText(type,text,str){
	var tipsStr = null;
	switch(type){
	case '1'://只能包含汉字、英文字母、数字和下划线
		if(!/^[0-9a-zA-Z\u4e00-\u9fa5_]+$/.test(text)){
			tipsStr = '"'+str+'"只能包含汉字、英文字母、数字和下划线！';
		}
		break;
	case '2'://验证姓名，可以是中文或英文
		if(!/^[A-Za-z\u4e00-\u9fa5]+$/.test(text)){
			tipsStr = '"'+str+'"只能包含汉字、英文字母！';
		}
		break;
	case '3'://手机号验证
		if(!/^1[34578]\d{9}$/.test(text)){
			tipsStr = '"'+str+'"格式不正确，请重填！';
		}
		break;
	case '4'://固定电话验证
		if(!/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test(text)){
			tipsStr = '"'+str+'"格式不正确，请重填！';
		}
		break;
	case '5'://联系方式验证：包括手机号和固定电话
		if(!/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$|^1[34578]\d{9}$/.test(text)){
			tipsStr = '"'+str+'"格式不正确，请重填！';
		}
		break;
	case '6'://身份证号验证
		if(!/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/.test(text)){
			tipsStr = '"'+str+'"格式不正确，请重填！';
		}
		break;
	case '7'://特殊字符
		//校验特殊字符
		if(checkSpecialChar(text)){
			tipsStr = '"'+str+'"包含特殊字符！';
		}
		break;
	case '8'://编号，只能输入英文字母和数字
		if(!/[0-9a-z]/i.test(text)){
			tipsStr = '"'+str+'"只能包含英文字母和数字！';
		}
		break;
	case '9'://邮箱
		if(!isEmail(text)){
			tipsStr = '"'+str+'"格式不正确，请重填！';
		}
		break;
	case '10'://可以输入中英文字符,.，。和空格
		if(!/^[0-9A-Za-z\u4e00-\u9fa5\,.，。\s]+$/.test(text)){
			tipsStr = '"'+str+'"只能包含汉字、英文字母和数字,.，。！';
		}
		break;
//	case '11':时间格式验证
//		if(!/^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/.test(text)){
//			tipsStr = '"'+str+'"不能为空！';
//		}
//		break;
	}
	return tipsStr;
}
/* 验证电子邮箱的格式 */
function isEmail(email) {
   var strEmail=$.trim(email);
   if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
  {
     return true;
  }else{
     return false;
  }
}

/**
 * 验证是否含有特殊字符
 * @param text
 */
function checkSpecialChar(val){
	var pattern = new RegExp("[`~!#$%^&*\\(\\)=+;'<>?\\|]");
	if(pattern.test(val)){
		return true
	}
	return false;;
}
/**
 * 验证失败提示
 * @param $node
 * @param hint
 */
function addCheckFalseStyle($node,hint){
	//alertModal(hint);
	$node.addClass("input-bor");
	$node.parent().append("<span class='text-red'>" + hint + "</span>");
}
/**
 * 验证字符串长度
 * @param message
 * @param MaxLenght
 * @returns
 */
function isSuperLong(val,MaxLength) {
	var tipsStr = null;
    var strlength = 0; //初始定义长度为0
    var txtval = $.trim(val);
    for (var i = 0; i < txtval.length; i++) {
        if (isCN(txtval.charAt(i)) == true) {
        	strlength = strlength + 4; //中文为4个字符
        } else {
        	strlength = strlength + 1; //英文一个字符
        }
    }
    if(strlength > MaxLength){
    	return true;
    }
    return false;
}
/**
 * 去除提示样式
 * @param $wrap
 */
function removeCheckStyle($wrap){
	$wrap.find('.input-bor').removeClass('input-bor');
	$wrap.find('span.text-red').remove();
}
function alertModal(msg){
	$("#msg-div-body").html(msg);
	$("#modal-sm").modal("show");	
}
/**
 * 验证字符串长度
 * @param message
 * @param MaxLenght
 * @returns
 */
function limitText(message,MaxLength) {
	var tipsStr = null;
    var strlength = 0; //初始定义长度为0
    var txtval = $.trim(message);
    for (var i = 0; i < txtval.length; i++) {
        if (isCN(txtval.charAt(i)) == true) {
        	strlength = strlength + 2; //中文为2个字符
        } else {
        	strlength = strlength + 1; //英文一个字符
        }
    }
    if(strlength > MaxLength){
    	tipsStr = "输入的内容超出了长度限制"; 
    }
    return tipsStr;
}
/**
 * 判断是不是中文
 * @param str
 * @returns
 */
function isCN(str) { 
	var regexCh = /[u00-uff]/;
	return !regexCh .test(str);
}


/**
 * 封装的Confirm框
 */
(function ($) {
    window.public_win = function () {
        var html = '<div id="[Id]" class="modal fade"  role="dialog" aria-labelledby="modalLabel">' +
                              '<div class="modal-dialog modal-sm">' +
                                  '<div class="modal-content" style="width:380px !important;">' +
                                      '<div class="modal-header " style="background-color:#108E79;   height:48px; font-size: 24px; color: #ffffff;" >' +
                                          '<button type="button" class="close" data-dismiss="modal" style="opacity: 1;color:#fff;" ><span  style="font-size:25px;color:#ffffff;font-weight:blod" aria-hidden="false">&times;</span><span class="sr-only">Close</span></button>' +
                                          '<h4 class="modal-title" id="modalLabel" style="font-size: 16px;font-family: 微软雅黑;line-height: 20px;">[Title]</h4>' +
                                      '</div>' +
                                      '<div class="modal-body" style="  padding: 15px 15px 0px 15px;">' +
                                      '<p style="    font-size: 14px;font-family: 微软雅黑;line-height: 38px; text-align:center;">[Message]</p>' +
                                      '</div>' +
                                       '<div class="modal-footer" style="border-top: 0px;">' +
        '<button type="button" class="btn btn-default pull-right cancl" style="margin-left:10px; width: 70px;  height: 26px; line-height:12px !important;font-size: 12px;font-family: 微软雅黑;" data-dismiss="modal">[BtnCancel]</button>' +
        '<button type="button" class="btn btn-primary pull-right ok" style="  background-color:#108E79; width: 70px; color:#FFFFFF;  height: 26px; line-height: 12px !important;font-size: 12px;font-family: 微软雅黑;"  data-dismiss="modal">[BtnOk]</button>' +
    '</div>' +
                                  '</div>' +
                              '</div>' +
                          '</div>';


        var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
                              '<div class="modal-dialog">' +
                                  '<div class="modal-content">' +
                                      '<div class="modal-header">' +
                                          '<button type="button" class="close"  data-dismiss="modal"><span class="sr-only">Close</span></button>' +
                                          '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
                                      '</div>' +
                                      '<div class="modal-body">' +
                                      '</div>' +
                                  '</div>' +
                              '</div>' +
                          '</div>';
        var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        var generateId = function () {
            var date = new Date();
            return 'mdl' + date.valueOf();
        }
        var init = function (options) {
            options = $.extend({}, {
                title: "操作提示",
                message: "提示内容",
                btnok: "12312",
                btncl: "取消",
                width: 200,
                flag:true,
                auto: false
            }, options || {});
            var modalId = generateId();
            var content = html.replace(reg, function (node, key) {
                return {
                    Id: modalId,
                    Title: options.title,
                    Message: options.message,
                    BtnOk: options.btnok,
                    BtnCancel: options.btncl
                }[key];
            });
            $('body').append(content);
            $('#' + modalId).modal({
                width: options.width,
                backdrop: 'static'
            });
            $('#' + modalId).on('hide.bs.modal', function (e) {
                $('body').find('#' + modalId).remove();
            });
            return modalId;
        }

        return {
            alert: function (options) {
                if (typeof options == 'string') {
                    options = {
                        message: options
                    };
                }
                var id = init(options);
                var modal = $('#' + id);
                modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
                modal.find('.cancl').hide();

                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            confirm: function (options) {
                var id = init(options);
                var modal = $('#' + id);
                if(options.flag){
                    modal.find('.ok').removeClass('btn-delete').addClass('btn-primary');
                    modal.find('.ok').text("确认")
                }else{
                    modal.find('.ok').removeClass('btn-primary').addClass('btn-delete');
                    modal.find('.ok').text("删除")
                    modal.find('.ok').css("background-color",'#ea344e')
                }
//                modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
                modal.find('.cancl').show();
                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                            modal.find('.cancl').click(function () { callback(false); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            dialog: function (options) {
                options = $.extend({}, {
                    title: 'title',
                    url: '',
                    width: 800,
                    height: 550,
                    onReady: function () { },
                    onShown: function (e) { }
                }, options || {});
                var modalId = generateId();

                var content = dialogdHtml.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title
                    }[key];
                });
                $('body').append(content);
                var target = $('#' + modalId);
                target.find('.modal-body').load(options.url);
                if (options.onReady())
                    options.onReady.call(target);
                target.modal();
                target.on('shown.bs.modal', function (e) {
                    if (options.onReady(e))
                        options.onReady.call(target, e);
                });
                target.on('hide.bs.modal', function (e) {
                    $('body').find(target).remove();
                });
            }
        }
    }();
})(jQuery);
/**
 * 验证文件格式是否正确
 * @param typeStr文件格式,都是大写(逗号隔开)
 * @param fileName 文件名或路径都可以
 * @returns {Boolean}
 */
function checkFileType(typeStr,fileName){
	if(!isEmpty(typeStr)){
		var fileType = fileName.substr(fileName.lastIndexOf(".")+1).toUpperCase();//得到的是后缀名,且转换为大写
		if(typeStr.indexOf(fileType)>-1){
			return true;
		}else{
			return false;
		}
	}
}
/**
 * 验证文件大小
 * @param maxSize单位为M
 * @returns {Boolean}
 */
function checkFileSize(obj,maxSize){
	if(maxSize==null){
		maxSize = 100;
	}
	var fileSize = 0;
	var isIE = /msie/i.test(navigator.userAgent) && !window.opera;      
	if (isIE && !obj.files) {     
		var filePath = obj.value;      
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");  
		var file = fileSystem.GetFile (filePath);        
		fileSize = file.Size;     
	}else { 
		var files = obj.files;
		if(files!=null && files.length>0){
			fileSize = files[0].size; 
		}
	} 
	if(fileSize>0){
		fileSize=Math.round(fileSize/1024/1024*100)/100; //单位为M
		if(fileSize>=maxSize){
		    return false;
		}
	}
	return true;
}