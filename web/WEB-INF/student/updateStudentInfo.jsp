<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="studentHomePage.jsp"%>


<div id="page-main" style="backgroud:#104d74;">
	<div class="row">
		<div class="col-sm-4 col-sm-offset-2">
			<h3 class="h3">修改个人信息：</h3>
			<hr />
		</div>
	</div>

	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/student/updateStudentInfo.do" enctype="multipart/form-data">
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
					<c:when test="${student.gender == 1}">
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
				<input type="hidden" name="classes.cid" value="${student.classes.cid }"/>
				<input readOnly name="classes.cname" type="text"
					class="form-control"
					value="${student.classes.cname }">
			</div>
		</div>

		<div class="form-group">
			<label for="zipcode" class="col-sm-2 control-label">专业</label>
			<div class="col-sm-5">
				<input readOnly name="classes.major.mname" type="text" class="form-control"
					value="${student.classes.major.mname }">
			</div>
		</div>



		<div class="form-group">
			<label for="zipcode" class="col-sm-2 control-label">简历</label>
			<input type="hidden" name="resume" value="${student.resume }"/>
			<div class="col-sm-5">
				<input name="file" type="file" class="form-control">
				<span class="text-danger">${errorMessage }</span>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6">
				<button type="submit" class="btn btn-success btn-block">更新</button>
			</div>
		</div>
	</form>
</div>