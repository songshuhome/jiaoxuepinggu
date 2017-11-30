<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<title>江西农业大学</title>
<link rel="stylesheet" type="text/css" href="assets/css/login.css" />
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" />
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<input type="hidden" id="baseUrl" value="${pageContext.request.contextPath}">
	<div class="container-fluid">
		<div class="row">
			<div id="header-h3">
				<h1 class="col-md-offset-5 col-xs-offset-4">审核评估</h1>
				<h2 class="col-md-offset-6 col-xs-offset-8">
					<small>知识问答</small>
				</h2>
			</div>
		</div>
		<form class="form-signin" action="<c:url value='user'/>"
				method="post" onsubmit="return manageLogin.login();">
				<input type="hidden" name="method" value="userLogin" />
		<div class="login-box col-md-offset-4 col-md-4 col-xs-12">
			<div class="login-content">
				<div class="row">
					<div class="col-md-4 col-sm-2 col-xs-0">
						<label for="num" id="label-num">StudentNumber</label>
					</div>
					<div class="col-md-6 col-sm-4 col-xs-12">
						<input type="text" id="userName" class="my-input" name="studentNumber"/>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-4 col-sm-2 col-xs-2">
						<label for="password" id="label-pass">Password</label>
					</div>
					<div class="col-md-6 col-xs-12">
						<input type="password" id="password" class="my-input" name="password"/>
					</div>

				</div>
				<hr id="hr-pass">
				<div class="row">
					<div class="login-button col-md-12 col-sm-12 col-xs-12">
						<button type="submit">Login</button><br/><br/>
						<p id="errorSpan" style="color: red">${errorUser}</p>
					</div>
				</div>

			</div>
		</div>
		</form>
	</div>
	<script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.min.js"></script>
	<script src="assets/js/user/userLogin.js"></script>
	
</body>
</html>
