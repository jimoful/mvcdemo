<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp" %>


<div id="page-main" style="backgroud:#104d74;">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<h3 class="h3">学生详细信息：</h3>
				<hr />
			</div>
		</div>

		
		
	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/updateStudentInfo.do" enctype="multipart/form-data">
		
		<input type="hidden" name="sid"
			value="${student.sid }" />

				
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">学号</label>
			<div class="col-sm-5">
				<input required readOnly name="sno" type="text"
					class="form-control"
					value="${student.sno }">

			</div>
		</div>

		<div class="form-group">
			<label for="realname" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-5">
				<input required name="name" type="text" class="form-control"
					value="${student.name }">
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-5">
				<input required name="age" type="number"
					class="form-control"
					value="${student.age }">
			</div>
		</div>

		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-5">
			
			<c:choose>
				<c:when test="${student.gender==1 }">
					<input type="radio" name="gender" value="1" checked>男
					<input type="radio" name="gender" value="0">女
				</c:when>
				<c:otherwise>
					<input type="radio" name="gender" value="1">男
					<input type="radio" name="gender" value="0" checked>女
				</c:otherwise>
			</c:choose>
				
			</div>
		</div>

		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">班级</label>
			<div class="col-sm-5">
				<select name="classes.cid">
				<c:forEach items="${classesList }" var="classes">
					<c:choose>
						<c:when test="${classes.cid==student.classes.cid }">
							<option value="${classes.cid }" selected>${classes.cname }</option>
						</c:when>
						<c:otherwise>
							<option value="${classes.cid }">${classes.cname }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="resume" class="col-sm-2 control-label">简历</label>
			<div class="col-sm-5">
				<span id="resume"><a href="${pageContext.request.contextPath }/util/download.do?fileName=${student.resume}">${student.resume}</a></span>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6">
				<button type="submit" class="btn btn-success btn-block">更新</button>
			</div>
		</div>
	</form>
</div>
