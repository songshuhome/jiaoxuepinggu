<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>江西农业大学-评估测评管理</title>
<%-- 全站样式 --%>
<jsp:include page="/WEB-INF/jsps/template_style.jsp"></jsp:include>
</head>
<body class="page-body skin-navy">
	<input type="hidden" id="baseUrl"
		value="${pageContext.request.contextPath}">
	<div class="page-container">
		<%--侧边栏 --%>
		<jsp:include page="/WEB-INF/jsps/sidebar.jsp"></jsp:include>
		<div class="main-content">
			<%--导航栏 --%>
			<jsp:include page="/WEB-INF/jsps/navbar.jsp"></jsp:include>
			<div class="page-title">
				<div class="title-env">
					<h1 class="title">评估测评管理</h1>
					<p class="description">您可以在此页面上对学生的测试结果进行查看。</p>
				</div>
			</div>
			<div class="row">
				<!-- Tabbed panel 2 -->
				<div class="panel panel-default panel-tabs">
					<!-- Add class "collapsed" to minimize the panel -->
					<div class="panel-heading">
						<h3 class="panel-title">结果列表</h3>
						<div class="panel-options">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab-4" data-toggle="tab">未通过</a>
								</li>
								<li><a href="#tab-5" data-toggle="tab">通过</a></li>
							</ul>
						</div>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div class="tab-pane active" id="tab-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<!-- 未通过面板 -->
										<table class="table table-bordered table-striped"
											id="example-12">
											<thead>
												<tr>
													<th>学院</th>
													<th>班级</th>
													<th>姓名</th>
													<th>分数</th>
												</tr>
											</thead>
											<tbody class="middle-align" id="noPass">

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="tab-5">
								<div class="panel panel-default">
									<div class="panel-body">
										<!--- 通过面板 -->
										<table class="table table-bordered table-striped"
											id="example-13">
											<thead>
												<tr>
													<th>学院</th>
													<th>班级</th>
													<th>姓名</th>
													<th>分数</th>
												</tr>
											</thead>
											<tbody class="middle-align" id="passCS">

											</tbody>
										</table>
									</div>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>

			<%--页脚 --%>
			<jsp:include page="/WEB-INF/jsps/footer.jsp"></jsp:include>
		</div>
	</div>

	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>

	<%-- 尾部内容 --%>
	<jsp:include page="/WEB-INF/jsps/template_tail.jsp" />

	<!-- Imported scripts on this page -->
	<script src="assets/js/datatables/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/dataTables.bootstrap.js"></script>
	<script src="assets/js/jquery.dataTables.yadcf.js"></script>
	<!--Specific JS for this page-->
	<script type="text/javascript">
		jQuery(document).ready(
				function($) {
					$("#example-2").dataTable(
							{
								aLengthMenu : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "所有" ] ]
							});
				});

		jQuery(document).ready(
				function($) {
					$("#example-3").dataTable(
							{
								aLengthMenu : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "所有" ] ]
							});

				});

		jQuery(document).ready(
				function($) {
					$("#example-4").dataTable(
							{
								aLengthMenu : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "所有" ] ]
							});

				});

		jQuery(document).ready(
				function($) {
					$("#example-5").dataTable(
							{
								aLengthMenu : [ [ 5, 10, 25, 50, 100, -1 ],
										[ 5, 10, 25, 50, 100, "所有" ] ]
							});

				});

		function queryAcademy(obj) {
			var academy = $(obj).find("span").text();
			$.ajax({
				url : $("#baseUrl").val()
						+ "/user?method=queryUserByAcademy&academy=" + academy,
				type : "POST",
				dataType : 'json',
				data : {
					'academy' : academy,
				},
				success : function(data) {
					var listUser = data.data;
					$("#passCS").empty();
					$("#noPass").empty();
					for (var i = 0; i < listUser.length; i++) {
						var user = listUser[i];// 得到每一个Aca对象
						if (user.status == 1) {
							var tr = "<tr>";
							tr += "<td>" + user.academy + "</td>";
							tr += "<td>" + user.classes + "</td>";
							tr += "<td>" + user.userName + "</td>";
							tr += "<td>" + user.grade + "</td>";
							tr += "</tr>";
							$("#passCS").append(tr);
						} else {
							var tr = "<tr>";
							tr += "<td>" + user.academy + "</td>";
							tr += "<td>" + user.classes + "</td>";
							tr += "<td>" + user.userName + "</td>";
							tr += "<td>" + user.grade + "</td>";
							tr += "</tr>";
							$("#noPass").append(tr);
						}
					}

					initDateTables('#example-12');
					initDateTables('#example-13');
				}
			});

		}

		function initDateTables(idName) {
			var table = $(idName).DataTable();
		}
	</script>
</body>

</html>