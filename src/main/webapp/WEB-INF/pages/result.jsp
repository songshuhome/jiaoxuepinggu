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
	<header>
		<input type="hidden" id="baseUrl"
			value="${pageContext.request.contextPath}"> <input
			type="hidden" id="frequency" value="${session_user.frequency}">
		<input type="hidden" id="answer" value="${answer}"> <input
			type="hidden" id="trueAnsewr" value="${trueAnsewr}">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="nav navbar-nav navbar-left"></br>
				<img src="assets/images/jxau.png" alt="Logo"/>
					
                    <div class="nav navbar-nav navbar-right avatar">
                            <img src="assets/images/u.ico" alt="120" class="img-circle visible-lg-inline-block"/>
                        <img src="assets/images/u64.ico" alt="120" class="img-circle hidden-lg"/>
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
		<div id="show-score" class="row">
			<div class="col-xs-offset-2">
				您的分数为：${session_user.grade} 分
				<c:choose>
					<c:when test="${session_user.grade < 80}">  
         				&nbsp;不及格，请重新考试！
					</c:when>
					<c:otherwise> 
					&nbsp;恭喜你及格！
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row" id="cir-answer">
			<div>
				<div class="row" id="re-exam"></div>
	</section>
	<footer>
		<div class="footer-content">
			&copy; 2005-2017 -<strong>蓝点工作室</strong>- 江西农业大学
		</div>
	</footer>
</body>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/user/result.js"></script>
<script>
	window.onload = showAnswers();
</script>
</html>
