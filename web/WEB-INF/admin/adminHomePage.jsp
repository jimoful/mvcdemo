<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
   
    <style type="text/css">
              @media (min-width: 768px){
            #letf-nav{
                width: 230px;
                margin-top: 65px;
                position: absolute;
                height: 800px;
                background-color:#eee;
            }
            
            #letf-nav a{
                color:#31708f;
            }
            
            #page-main{
                margin-left: 260px;
            }
            #navbar-brand{
            	margin-top:5px;
                margin-left: 16px;
                font-weight: 550;
                font-size: 33px;
                color:white;
            }
            
            #nav{
            	height:60px;
            	margin-bottom:70px;
            	background:#185188;
            	
            }
            
            #right_nav{
            	margin-top:5px;
            	font-size:14px;
            }
            
            #right_nav a{
            	color:white;
            }
           
        }
    </style>

</head>
<body>
    <nav id="nav" class="navbar navbar-default navbar-static-top">
        <!-- 顶部导航左侧标志 -->
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/admin/toHomePage.do"  id="navbar-brand" class="navbar-brand">后台管理</a>
        </div>
        
        <!-- 顶部导航右侧注销-->
        <ul id="right_nav" class="nav navbar-nav navbar-right" style="margin-right:25px;">
            <li><a href="${pageContext.request.contextPath}/admin/logout.do"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
        </ul>
        
        <div id="letf-nav">
			<ul class="nav">
				
				<li>
					<a href="#sub1" data-toggle="collapse">学生管理<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
					<ul id="sub1" class="nav collapse">
						<li><a href="${pageContext.request.contextPath}/admin/findAllStudentList.do?page=1"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;查看所有学生</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/toAddStudent.do"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;添加学生</a></li>
					</ul>
				</li>
				<li>
					<a href="#sub2" data-toggle="collapse">企业管理<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
					<ul id="sub2" class="nav collapse">
						<li><a href="${pageContext.request.contextPath}/admin/findAllEnterpriseList.do?page=1"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;查看所有企业</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/toVerifyEnterprise.do?page=1"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;审核企业</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/toAddEnterprise.do"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;添加企业</a></li>
					</ul>
				</li>
				<li>
					<a href="#sub3" data-toggle="collapse">修改密码<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
					<ul id="sub3" class="nav collapse">
						<li><a href="${pageContext.request.contextPath}/admin/toUpdateAdminPassword.do"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;修改密码</a></li>
					</ul>
				</li>
				
			</ul>
		</div>
      
  </nav>


</body>
</html>
