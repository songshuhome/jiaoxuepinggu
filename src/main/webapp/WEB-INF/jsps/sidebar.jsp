<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 侧边栏 -->
<div class="sidebar-menu toggle-others fixed">
	<div class="sidebar-menu-inner">
		<header class="logo-env">
			<div class="logo">
				<a href="#" class="logo-expanded"> <!--<img src="assets/img/logo@2x.png" width="80" alt="" />-->
					<span style="font-size: large; color: rgba(252, 249, 255, 0.65)"></span>
				</a>
			</div>
			<!--设置-->
			<div class="settings-icon">
				<a href="#" data-toggle="settings-pane" data-animate="true"> <i
					class="linecons-cog"></i>
				</a>
			</div>
		</header>
		<!--右侧导航栏菜单sidebar-->
		<ul id="main-menu" class="main-menu">
			<li><a> <i class="fa-user fontstyle"></i> <span
					class="title">院系信息</span>
			</a>
				<ul>
					<li><a href="Javascript:void(0);"
						onclick="queryAcademy(this);"> <span class="title">农学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">林学院/园林与艺术学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">动物科学技术学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">工学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">经济管理学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">国土资源与环境学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">计算机与信息工程学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title" id="soft">软件学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">人文与公共管理学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">理学院</span>
					</a><a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">职业师范技术学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">食品科学与工程学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">生物科学与工程学院</span>
					</a> <a href="Javascript:void(0);" onclick="queryAcademy(this);"> <span
							class="title">外国语学院</span>
					</a></li>
				</ul></li>
		</ul>
	</div>
</div>