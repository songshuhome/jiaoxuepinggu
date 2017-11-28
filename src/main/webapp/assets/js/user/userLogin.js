var manageLogin = {
		
	// 校验输入是否为空
	check: function(userName, password) {
	    if (userName == null || userName == undefined || userName == " " || userName.length != 8) {
	    	return false;
	    }else if(password == null || password == undefined || password == " " || password.length != 6) {
	    	return false;
	    }
	     return true;
	},
	
	//点击登录触发的事件
	init: function() {
		
		// 用户登录
        $("#goLogin").click(function() {
            manageLogin.login();
        });
	},
	
	//检验信息
	validateIsNull: function() {
		var userName = $.trim($('#userName').val());
		if(!userName) {
			$("#errorSpan").html("用户名不能为空!");
			return false;
		}
		var password = $.trim($('#password').val());
		if(!password) {
			$("#errorSpan").html("用户名不能为空!");
			return false;
		} 
		
		if (!manageLogin.check(userName,password)) {
	    	$("#errorSpan").html("用户名,密码错误!");
	        return false;
	    }
		return true;
	},
	
	//登录
	login: function() {
		return manageLogin.validateIsNull();
	}
}
// 入口
$(function(){
	 manageLogin.init();
});