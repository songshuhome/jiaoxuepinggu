<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>江西农业大学</title>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="assets/css/quiz.css" />
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="nav navbar-nav navbar-left">
					
                    <div class="nav navbar-nav navbar-right avatar">
                            <img src="assets/images/u.ico" alt="120" class="img-circle visible-lg-inline-block"/>
                        <img src="assets/images/u64.ico" alt="120" class="img-circle hidden-lg"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size: 30px">${session_user.userName}</strong>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-success btn-lg"><a href="<c:url value="/user?method=quit"/>">退出</a></button>
                    </div>

                <div class="container">
                    <div class="navbar-header">

                    </div>
                </div>
            </div>
        </nav>
    </header>
    <section class="main-content">
        <div class="logo">
            <img src="assets/images/jxau_big.png" alt="Logo" class="hidden-lg"/>
        </div>
        <div>
            <h1>审核评估</h1>
            <h2>知识问答</h2>
        </div>
        <div class="row">
            <div class="center-button">
                <button class="button-start" onclick="jump()">开始考试</button>
            </div>
        </div>
    </section>
    <footer>
        <div class="footer-content">
            &copy; 2005-2017 -<strong>
            <a href="https://baike.baidu.com/item/%E6%B1%9F%E8%A5%BF%E5%86%9C%E4%B8%9A%E5%A4%A7%E5%AD%A6%E8%BD%AF%E4%BB%B6%E5%AD%A6%E9%99%A2%E8%93%9D%E7%82%B9%E5%B7%A5%E4%BD%9C%E5%AE%A4/10848071?fr=aladdin">
                蓝点工作室</a></strong>-  江西农业大学
        </div>
    </footer>
</body>
<script>
    function jump() {
        window.location.href="quiz.jsp";
    }
</script>
</html>
