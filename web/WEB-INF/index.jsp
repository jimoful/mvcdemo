
<!DOCTYPE html>
<html>
<head>
<title>登录系统</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <style type="text/css">
        @media (min-width: 768px){
            #navbar-brand{
            	margin-top:5px;
                margin-left: 16px;
                font-weight: 400;
                font-size: 33px;
                color:#185188;
            }
            #nav{
            	height:70px;
            	margin-bottom:70px;
            }
            #right_nav{
            	margin-top:5px;
            	font-size:16px;
            }
            body{
            	background:#185188;
            	color:#fff;
            }
        }
    </style>

</head>
<body>

<nav id="nav" class="navbar navbar-default navbar-static-top">
        <!-- 顶部导航左侧标志 -->
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath }/index.jsp"  id="navbar-brand" class="navbar-brand">NUAA-FMS</a>
        </div>
        
        <!-- 顶部导航右侧注销，欢迎 -->
        <ul id="right_nav" class="nav navbar-nav navbar-right" style="margin-right:25px;">
            <li><a href="${pageContext.request.contextPath }/enterprise/toRegisterEnterprise.do"><span class="glyphicon glyphicon-leaf"></span>&nbsp;用户注册</a></li>
        </ul>

  </nav>





	<div class="container ">
	
	<div id="i1">
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h1>学生登录：</h1>
			<hr />
		</div>
	</div>
	
	<form id="form1" class="form-horizontal" action="${pageContext.request.contextPath}/student/login.do" method="post">
		
		<div class="form-group">
				<label for="username" class="col-sm-2 col-sm-offset-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
				<div class="col-sm-5">
					<input name="sno" value="201322450530" type="text" class="form-control" id="username" placeholder="请输入学号">
					
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<div class="col-sm-5">
					<input name="password" value="000000" type="password" class="form-control" id="password" placeholder="请输入密码">
					<span class="text-danger">${ errorMessage }</span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">验证码：</label>
				<div class="col-sm-4">
					<input name="verificationCode" type="text" class="form-control verificationInput" placeholder="请输入验证码">
					
					<span></span>
				</div>
				
				<div class="col-sm-3 ">
					<img class="verificationCode" src="${pageContext.request.contextPath }/util/getVerificationCode.do" width=70 height=35/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<span class="codeError"></span>
                    
				</div>
			</div>
	
	
	
	
	
			
			<div class="col-sm-offset-3 col-sm-6">
				<button id="btn1" type="submit" class="btn btn-success btn-lg btn-block">登录</button>
			</div>
		
		
	</form>
</div><!-- i1	 -->




	<div id="i2" class="hidden">
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h1>企业登录：</h1>
			<hr />
		</div>
	</div>
	
	<form id="form2" class="form-horizontal" action="${pageContext.request.contextPath}/enterprise/login.do" method="post">
		
		<div class="form-group">
				<label for="email" class="col-sm-2 col-sm-offset-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
				<div class="col-sm-5">
					<input type="email" value="1@1.com" name="email" class="form-control" id="email" placeholder="请输入邮箱">
					<span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<div class="col-sm-5">
					<input type="password" value="000000" name="password" class="form-control" id="password" placeholder="请输入密码">
					<span class="text-danger">${ errorMessage }</span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">验证码：</label>
				<div class="col-sm-4">
					<input type="text" name="verificationCode" class="form-control verificationInput" placeholder="请输入验证码">
					
					<span></span>
				</div>
				
				<div class="col-sm-3 ">
					<img class="verificationCode" src="${pageContext.request.contextPath }/util/getVerificationCode.do" width=70 height=35/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<span class="codeError"></span>
				</div>
			</div>
	
	
	
	
	
			
			<div class="col-sm-offset-3 col-sm-6">
				<button id="btn2" type="submit" class="btn btn-success btn-lg btn-block">登录</button>
			</div>
		
		
	</form>
</div><!-- i2	 -->



	<div id="i3" class="hidden">
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h1>管理员登录：</h1>
			<hr />
		</div>
	</div>
	
	<form id="form3" class="form-horizontal" action="${pageContext.request.contextPath}/admin/login.do" method="post">
		
		<div class="form-group">
				<label for="name" class="col-sm-2 col-sm-offset-2 control-label">用户名：</label>
				<div class="col-sm-5">
					<input type="text" name="name" value="admin" class="form-control" id="name" placeholder="请输入用户名">
					<span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<div class="col-sm-5">
					<input type="password" name="password" value="000000" class="form-control" id="password" placeholder="请输入密码">
					<span class="text-danger">${ errorMessage }</span>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 col-sm-offset-2 control-label">验证码：</label>
				<div class="col-sm-4">
					<input type="text" name="verificationCode" class="form-control verificationInput" placeholder="请输入验证码">
					
					<span></span>
				</div>
				
				<div class="col-sm-3 ">
					<img class="verificationCode" src="${pageContext.request.contextPath }/util/getVerificationCode.do" width=70 height=45/>
				</div>
				
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<span class="codeError"></span>
				</div>
			</div>
	
	
	
	
	
			
			<div class="col-sm-offset-3 col-sm-6">
				<button id="btn3" type="submit" class="btn btn-success btn-lg btn-block">登录</button>
			</div>
        <span>span</span>
		
		
	</form>
</div><!-- i3	 -->


</div>
<!-- container -->


	<div class="radio col-md-offset-3">
				<div class="radio-inline" style="margin-left:50px;">
					选择角色：
				</div>
				<div class="radio-inline">
				<input id="i1" type="radio" name="username" value="i1" checked/>学生
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
        		<div class="radio-inline">
        		<input id="i2" type="radio" name="username" value="i2" />企业
        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		</div>
        		<div class="radio-inline">
        		<input id="i3" type="radio" name="username" value="i3" />管理员
				</div>
			</div>
    <div id="current-time" style="width: 600px ;margin:0 auto;background-size: 40% 20%;background-color: darkcyan;text-align: center;
    font-size:40px;font-family: 'Lucida Console', monospace;"></div>







<script type="text/javascript">
	

		$(function(){
            //时间
            setInterval(function() {
                var now = (new Date()).toLocaleString();
                $('#current-time').text(now);
            }, 1000);

			var flag = false;
			//<input id="i2" type="radio" name="username" value="i2" />企业
			$("input:radio[name='username']").change(function(){
				var id= $(this).val();
				if(id=="i1"){
					$("#i1").attr("class","show");
					$("#i2").attr("class","hidden");
					$("#i3").attr("class","hidden");
				}else if(id=="i2"){
					$("#i2").attr("class","show");
					$("#i1").attr("class","hidden");
					$("#i3").attr("class","hidden");
				}else{
					$("#i3").attr("class","show");
					$("#i1").attr("class","hidden");
					$("#i2").attr("class","hidden");
				}
			});
			//更新验证码，点击一下发出src请求，每次后面多加一个？。
			$(".verificationCode").click(function(){
				var code = $(".verificationCode").attr("src");
				$(".verificationCode").attr("src",code+"?");
			});
			
			
			//遍历，为每个对象（第一个参数）执行function函数（第二个参数）
			$.each($(".verificationInput"),function(){
				$(this).blur(function(){
					var value = $(this).val();
				
					var path ="${pageContext.request.contextPath}/util/ajaxCheckverificationCode.do?verificationCode="+value;
					
					
					flag = false;
                    //异步调用
					$.ajax({
						type: "post",
						url: path,
						success:function(data){
							//alert(data);
							$(".codeError").text(data);
							if(data==""){
								flag = true;
							}
						}
					});
				});
			});

            $.each($(".verificationInput"),function(){
                $(this).blur(function(){
                    var value=$(this).val();
                })

            })
			
			$("#c").click(function(){
				if(flag){
					return true;
				}else{
					return false;
				}
				
			});
			$("#btn2").click(function(){
				if(flag){
					return true;
				}else{
					return false;
				}
				
			});
			$("#btn3").click(function(){
				if(flag){
					return true;
				}else{
					return false;
				}
				
			});
            //选择div中所有span元素
           // $("div span").css("font-size","40px");
	});





</script>

</body>
</html>
