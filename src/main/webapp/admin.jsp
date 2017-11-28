<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<title>江西农业大学</title>
<link rel="stylesheet" type="text/css" href="assets/css/admin.css" />
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
</head>
<body>
	<header></header>
	<section class="main-content">
	<div class="login-box">
		<div class="login-content">
			<form class="form-signin" action="<c:url value='user'/>"
				method="post" onsubmit="return manageLogin.login();">
				<input type="hidden" name="method" value="login" />
				<div class="">
					<label for="num">StudentNumber</label> <input type="text" id="userName"
						name="studentNumber" class="my-input" />
					<hr>
				</div>
				<div>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="my-input" />
				</div>
				<hr>
				<div class="login-button">
					<button type="submit">Login</button>
					<p style="color: red; font-weight: 900">${msg}</p>
				</div>
			</form>
		</div>
	</div>
	</section>
	<footer>
	<div class="footer-content">
		&copy; 2005-2017 -<strong> <a
			href="https://baike.baidu.com/item/%E6%B1%9F%E8%A5%BF%E5%86%9C%E4%B8%9A%E5%A4%A7%E5%AD%A6%E8%BD%AF%E4%BB%B6%E5%AD%A6%E9%99%A2%E8%93%9D%E7%82%B9%E5%B7%A5%E4%BD%9C%E5%AE%A4/10848071?fr=aladdin">
				蓝点工作室</a></strong>- 江西农业大学
	</div>
	</footer>
	<script src="assets/js/user/userLogin.js"></script>
</body>
</html>