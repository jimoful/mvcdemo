<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="studentHomePage.jsp" %>


<div id="page-main" style="backgroud:#104d74;">
	
	
	
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<h3 class="h3">查看个人信息：</h3>
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>学号：</span>
				<span class="text-info">${student.sno }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>姓名：</span>
				<span class="text-info">${student.name }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>年龄：</span>
				<span class="text-info">${student.age }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>性别：</span>
				<span class="text-info">
					<c:choose>
						<c:when test="${student.gender == 1 }">
							男
						</c:when>
						<c:otherwise>
							女
						</c:otherwise>
					</c:choose>
				</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>班级：</span>
				<span class="text-info">${student.classes.cname }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>专业：</span>
				<span class="text-info">${student.classes.major.mname }</span>
				<hr />
			</div>
		</div>
	
	<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>简历：</span>
				<span class="text-info"><a href="${pageContext.request.contextPath }/util/download.do?fileName=${student.resume }">${student.resume }</a></span>
			</div>
		</div>
	
</div>