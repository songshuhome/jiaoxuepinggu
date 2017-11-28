<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

				<nav class="navbar user-info-navbar" role="navigation">
					<ul class="user-info-menu left-links list-inline list-unstyled">
						
						<li class="dropdown hover-line">
							<ul class="dropdown-menu messages">
								<li>
									<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
										<li class="active">
											<!-- "active" class means message is unread -->
											<a href="#">
												<span class="line"> <strong>Luc Chartier</strong> <span
												class="light small">- yesterday</span>
												</span> <span class="line desc small"> This ainât our first item, it
												is the best of the rest. </span>
											</a>
										</li>
										<li>
											<a href="#">
												<span class="line"> Hayden Cartwright <span
												class="light small">- a week ago</span>
												</span> <span class="line desc small"> Whose her enjoy chief new
												young. Felicity if ye required likewise so doubtful. </span>
											</a>
										</li>
									</ul>
								</li>

								<li class="external">
									<a href="#">
										<span>All Messages</span> <i class="fa-link-ext"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="dropdown hover-line">
							<ul class="dropdown-menu notifications">
								<li class="top">
									<p class="small">
										<a href="#" class="pull-right">Mark all Read</a>
										You have <strong>3</strong> new notifications.
									</p>
								</li>

								<li>
									<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
										<li class="active notification-success">
											<a href="#">
												<i class="fa-user"></i> <span class="line"> <strong>New
													user registered</strong>
											</span> <span class="line small time"> 30 seconds ago </span>
											</a>
										</li>
									</ul>
								</li>
								<li class="external">
									<a href="#">
										<span>View all notifications</span> <i class="fa-link-ext"></i>
									</a>
								</li>
							</ul>
						</li>
					</ul>

					<!-- Right links for user info navbar -->
					<ul class="user-info-menu right-links list-inline list-unstyled">
						<li class="search-form always-visible">
							<!-- You can add "always-visible" to show make the search input visible -->
							<form method="get" action="#">
								<input type="text" name="s" class="form-control search-field" placeholder="输入搜索内容..." />
								<button type="submit" class="btn btn-link">
								<i class="linecons-search"></i>
							</button>
							</form>
						</li>

						<li class="dropdown user-profile">

							<a href="#" data-toggle="dropdown">
								<img src="assets/img/user.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
								<span>${session_admin.userName }&nbsp;&nbsp;&nbsp;&nbsp;</span>
							</a>
							<ul class="dropdown-menu user-profile-menu list-unstyled">
								<li>
									<a href="#settings">
										<i class="fa-wrench"></i> 设置
									</a>
								</li>
								<li>
									<a href="#userIndex">
										<i class="fa-user"></i> 主页
									</a>
								</li>
								<li>
									<a href="#help">
										<i class="fa-info"></i> 帮助
									</a>
								</li>
								<li class="last">
									<a href="<c:url value="/user?method=quit"/>">
										<i class="fa-lock"></i> 注销
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</nav>

