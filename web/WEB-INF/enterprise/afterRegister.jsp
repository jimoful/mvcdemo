﻿
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>


<style type="text/css">
@media ( min-width : 768px) {
	#navbar-brand {
		margin-top: 5px;
		margin-left: 16px;
		font-weight: 550;
		font-size: 33px;
		color: #185188;
	}
	#nav {
		height: 60px;
		margin-bottom: 70px;
	}
	#right_nav {
		margin-top: 5px;
		font-size: 16px;
	}
	body {
		background: #185188;
		color: #fff;
	}
	#h1{
		margin-top:150px;
		text-align:center;
	}
}
</style>



</head>

<body>



	<nav id="nav" class="navbar navbar-default navbar-static-top">
		<!-- 顶部导航左侧标志 -->
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath }/index.jsp"
				id="navbar-brand" class="navbar-brand">院企联合培养系统</a>
		</div>

		<!-- 顶部导航右侧注销，欢迎 -->
		<ul id="right_nav" class="nav navbar-nav navbar-right"
			style="margin-right:25px;">
			<li><a
				href="${pageContext.request.contextPath }/enterprise/toRegisterEnterprise.do"><span
					class="glyphicon glyphicon-leaf"></span>&nbsp;企业注册</a>
			</li>
		</ul>

	</nav>





	<div class="container ">
		<h1 id="h1">您已注册完成，请耐心等待管理员审核...</h1>
	</div>
</body>
</html>
