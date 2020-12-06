//错误提示
function showError(id,msg) {
	$("#"+id+"Ok").hide();
	$("#"+id+"Err").html("<i></i><p>"+msg+"</p>");
	$("#"+id+"Err").show();
	$("#"+id).addClass("input-red");
}
//错误隐藏
function hideError(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id).removeClass("input-red");
}
//显示成功
function showSuccess(id) {
	$("#"+id+"Err").hide();
	$("#"+id+"Err").html("");
	$("#"+id+"Ok").show();
	$("#"+id).removeClass("input-red");
}


//打开注册协议弹层
function alertBox(maskid,bosid){
	$("#"+maskid).show();
	$("#"+bosid).show();
}
//关闭注册协议弹层
function closeBox(maskid,bosid){
	$("#"+maskid).hide();
	$("#"+bosid).hide();
}

//注册协议确认
$(function() {
	$("#agree").click(function(){
		var ischeck = document.getElementById("agree").checked;
		if (ischeck) {
			$("#btnRegist").attr("disabled", false);
			$("#btnRegist").removeClass("fail");
		} else {
			$("#btnRegist").attr("disabled","disabled");
			$("#btnRegist").addClass("fail");
		}
	});

	$(function () {
		$("#phone").on("blur",function () {
			var phone = $.trim($("#phone").val());
			if(phone == ""){
				showError("phone","手机号不能为空");
			}else if (!/^1[1-9]\d{9}$/.test(phone)){
				showError("phone","号码格式错误")
			}else{
				hideError("phone");
				//如果手机号码格式没有错误则去数据库查询一下该手机号是否已经注册过了
				$.ajax({
					url:contextPath+"/loan/checkPhone",
					dataType:"json",
					type:"get",
					data:{
						phone:phone
					},
					success:function (resp) {
						if (resp.error == 0){
							showSuccess("phone");
						}else if (resp.error == 1){
							showError("phone",resp.message)
						}else {
							showError("phone",resp.message)
						}
					}
				})
			}
		});
		$("#phone").on("focus",function () {
			hideError("phone")
		})
	})
});
