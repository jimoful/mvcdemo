<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>

  <style type="text/css">
        @media (min-width: 768px){
          
            
            #navbar-brand{
            	margin-top:5px;
                margin-left: 16px;
                font-weight: 550;
                font-size: 33px;
                color:white;
                
            }
            #nav{
            	height:60px;
            	
            	background:#185188;
            	
            }
           
        }
    </style>


</head>
<body>


<nav id="nav" class="navbar navbar-default navbar-static-top">
        <!-- 顶部导航左侧标志 -->
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath }/index.jsp"  id="navbar-brand" class="navbar-brand">院企联合培养系统</a>
        </div>
        

  </nav>



	<div id="page-main" style="backgroud:#104d74;">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<h1>企业注册</h1>
				<hr />
			</div>
		</div>

		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/enterprise/register.do">
		
			<div class="form-group">
				<label for="email" class="col-sm-2 col-sm-offset-2 control-label">企业名称：</label>
				<div class="col-sm-5">
					<input required name="name" type="text" class="form-control" id="name"
						placeholder="name"> 
						<span id="nameError" class="text-danger"></span>
						
				</div>
			</div>
		
			<div class="form-group">
				<label for="username" class="col-sm-2  col-sm-offset-2 control-label">企业邮箱：</label>
				<div class="col-sm-5">
					<input required name="email" type="email" class="form-control" id="email"
						placeholder="email"> <span id="emailError"
						class="text-danger"></span>
						<span id="emailError2" class="text-danger"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2  control-label">联系电话：</label>
				<div class="col-sm-5">
					<input required name="phone" type="text" class="form-control" id="phone" placeholder="phone">
					<span id="phoneError" class="text-danger"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="realname" class="col-sm-2 col-sm-offset-2  control-label">联系人姓名：</label>
				<div class="col-sm-5">
					<input name="username" type="text" class="form-control" id="username"
						placeholder="username">
					<span id="usernameError" class="text-danger"></span>
				</div>
			</div>


			<div class="form-group">
				<label for="phone" class="col-sm-2  col-sm-offset-2 control-label">登录密码：</label>
				<div class="col-sm-5">
					<input required name="password" type="password" class="form-control" id="password"
						placeholder="password"> <span id="passwordError"
						class="text-danger"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="address" class="col-sm-2 col-sm-offset-2  control-label">描述：</label>
				<div class="col-sm-5">
					<textarea name="description" rows="5" class="form-control"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="zipcode" class="col-sm-2  col-sm-offset-2 control-label">地址：</label>
				<div class="col-sm-5">
					<input name="address" type="text" class="form-control" id="address"
						placeholder="address"> <span id="addressError"
						class="text-danger"></span>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-5">
					<button type="submit" class="btn btn-success btn-block">注册</button>
				</div>
			</div>
		</form>
	</div>


	<script type="text/javascript">
		$(document).ready(
			function() {
			
				$("#name").blur(function() {
					var value = $(this).val();
					if (!/^\w{1,30}$/
							.test(value)) {
						$("#nameError").text("企业名称长度应在1到30之间~");
					}else{
						$("#nameError").text("");
					}
				});
				
				$("#email").blur(function() {
					var value = $(this).val();
					if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
							.test(value)) {
						$("#emailError").text("邮箱格式错误~");
					}else{
						$("#emailError").text("");
					}
					
					var path ="${pageContext.request.contextPath}/enterprise/ajaxCheckEmail.do?email="+value;
					
					$.ajax({
						type: "post",
						url: path,
						success:function(data){
							$("#emailError2").text(data);
						}
					});
					
				});
				
				
				$("#phone").blur(function() {
					var value = $(this).val();
					if (!/^\d{5，20}$/
							.test(value)) {
						$("#phoneError").text("格式错误，请输入5到20位纯数字~");
					}else{
						$("#phoneError").text("");
					}
				});
				
				$("#username").blur(function() {
					var value = $(this).val();
					if (!/^\w{1,20}$/
							.test(value)) {
						$("#usernameError").text("名称长度应在1到20之间~");
					}else{
						$("#usernameError").text("");
					}
				});
				
				$("#password").blur(function() {
					var value = $(this).val();
					if (!/^\w{6,20}$/
							.test(value)) {
						$("#passwordError").text("密码长度应在6到20之间~");
					}else{
						$("#passwordError").text("");
					}
				});
				
				
				$("#address").blur(function() {
					var value = $(this).val();
					if (!/^\w{1,20}$/
							.test(value)) {
						$("#addressError").text("地址长度应在1到20之间~");
					}else{
						$("#addressError").text("");
					}
				});
			});
	</script>
</body>
</html>
