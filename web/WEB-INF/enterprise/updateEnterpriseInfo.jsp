<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="enterpriseHomePage.jsp" %>


<div id="page-main" style="backgroud:#104d74;">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<h3 class="h3">修改企业简介：</h3>
				<hr/>
			</div>
		</div>

		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/enterprise/updateEnterpriseInfo.do">
			<input type="hidden" name="eid" value="${enterprise.eid }"/>
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">企业名称：</label>
				<div class="col-sm-5">
					<input required readOnly name="name" type="text" class="form-control" id="username"
						value="${enterprise.name }">
				</div>
			</div>

			<div class="form-group">
				<label for="realname" class="col-sm-2 control-label">企业邮箱：</label>
				<div class="col-sm-5">
					<input name="email" type="email" class="form-control" id="realname"
						value="${enterprise.email }">
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">企业联系人：</label>
				<div class="col-sm-5">
					<input required name="username" type="text" class="form-control" id="email"
						value="${enterprise.username }">
				</div>
			</div>

			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">联系电话：</label>
				<div class="col-sm-5">
					<input required name="phone" type="text" class="form-control" id="phone"
						value="${enterprise.phone }">
				</div>
			</div>

			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">企业描述：</label>
				<div class="col-sm-5">
					<input name="description" type="text" class="form-control" id="address"
						value="${enterprise.description }">
				</div>
			</div>

			<div class="form-group">
				<label for="zipcode" class="col-sm-2 control-label">企业地址：</label>
				<div class="col-sm-5">
					<input name="address" type="text" class="form-control" id="zipcode"
						value="${enterprise.address }">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-6">
					<button type="submit" class="btn btn-success btn-block">更新</button>
				</div>
			</div>
		</form>
	</div>