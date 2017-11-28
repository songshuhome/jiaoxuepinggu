<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<title>江西农业大学</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/quiz.css" />

</head>
<body>

	<c:if test="${session_user.userName==''}">
		<script type="text/javascript">
			window.location.href="login.jsp";
		</script>
	</c:if>
	<header>
		<input type="hidden" id="baseUrl"
			value="${pageContext.request.contextPath}"> <input
			type="hidden" id="quizError" value="${quizError}">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="nav navbar-nav navbar-left">
				</br> <img src="assets/images/jxau.png" alt="Logo" />

				<div class="nav navbar-nav navbar-right avatar">
					<img src="assets/images/u.ico" alt="120"
						class="img-circle visible-lg-inline-block" /> <img
						src="assets/images/u64.ico" alt="120" class="img-circle hidden-lg" />
					&nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size: 30px">${session_user.userName}</strong>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-success btn-lg"><a href="<c:url value="/user?method=quit"/>">退出</a></button>
				</div>

				<div class="container">
					<div class="navbar-header"></div>
				</div>
			</div>
		</nav>
	</header>
	<section class="main-content">
		<div class="row">
			<div class="slide-container col-xs-offset-2" id="quiz-container">
			<span style="color: red" id="error"></span>
				<div class="row">
					<div class="question-number col-xs-1" id="number"></div>
					<div class="question col-xs-10" id="question"></div>
				</div>
				<div class="row">
					<ul class="answers col-xs-12" id="answer">
					</ul>
				</div>
				<div class="row" id="arrow">
					<div class="col-xs-1">
						<a class=".pre" onclick="pre()"><img
							src="assets/images/right.png" class="left-arrow"></a>
					</div>
					<div class="col-xs-offset-8">
						<a class=".next" onclick="next()"><img
							src="assets/images/right.png"></a>
						<p style="color: white">请完成题目！</p>
					</div>
				</div>
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
</body>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/user/quiz.js"></script>
<script type="text/javascript">
	var quizError = $("#quizError").val();
	if(quizError != null && quizError != undefined && quizError != " " && quizError.length > 0) {
		 $("#error").html(quizError+"");
	}
</script>
</html>
