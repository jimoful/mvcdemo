<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp"%>
<style type="text/css">
    .btn{
        background: #761c19;
    }
</style>
<div id="page-main" style="backgroud:blue;">
	<div class="row">
		<div class="col-sm-4 col-sm-offset-2">
			<h3 class="h3">添加学生：</h3>
			<hr />
		</div>
	</div>

	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/addStudent.do">
		<div class="form-group">
			<label class="col-sm-2 control-label">学号：</label>
			<div class="col-sm-5">
				<input required name="sno" type="text" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-5">
				<input required name="name" type="text" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄：</label>
			<div class="col-sm-5">
				<input required name="age" type="number"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-5">
				<input type="radio" name="gender" value="1" checked>男
				<input type="radio" name="gender" value="0">女
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">班级：</label>
			<div class="col-sm-5">
				<select name="classes.cid">
				<c:forEach items="${classesList }" var="classes">
					
						<option value="${classes.cid }">${classes.cname }</option>
					
				</c:forEach>
				</select>
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6">
				<button type="submit" class="btn btn-success btn-block">添加</button>
			</div>
		</div>
	</form>
</div>