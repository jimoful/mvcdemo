<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp"%>


<div id="page-main" style="backgroud:#104d74;">
	<div class="row">
		<div class="col-sm-4 col-sm-offset-2">
			<h3 class="h3">添加企业：</h3>
			<hr />
		</div>
	</div>

	<form class="form-horizontal" method="post"
		action="${pageContext.request.contextPath }/admin/addEnterprise.do">
		<div class="form-group">
			<label class="col-sm-2 control-label">企业名称：</label>
			<div class="col-sm-5">
				<input required name="name" type="text"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">企业邮箱：</label>
			<div class="col-sm-5">
				<input required name="email" type="text"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系电话：</label>
			<div class="col-sm-5">
				<input required name="phone" type="text"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系人：</label>
			<div class="col-sm-5">
				<input required name="username" type="text"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">企业描述：</label>
			<div class="col-sm-5">
				<input required name="description" type="text"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">企业地址：</label>
			<div class="col-sm-5">
				<input required name="address" type="text"
					class="form-control">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6">
				<button type="submit" class="btn btn-success btn-block">添加</button>
			</div>
		</div>
	</form>
</div>