<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp" %>



<div id="page-main" style="backgroud:#104d74;">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<h3 class="h3">修改密码：</h3>
				<hr />
			</div>
		</div>

		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/updateAdminPassword.do">
			<input type="hidden" name="aid" value="${sessionScope.admin.aid }"/>
			<div class="form-group">
				<label for="oldPassword" class="col-sm-2 control-label">请输入旧密码：</label>
				<div class="col-sm-5">
					<input required name="password" type="text" class="form-control" id="oldPassword">
					<span class="text-danger">${errorMessage }
					</span>
				</div>
			</div>
			
			<div class="form-group">
				<label for="newPassword" class="col-sm-2 control-label">请输入新密码：</label>
				<div class="col-sm-5">
					<input required name="newPassword" type="text" class="form-control" id="newPassword">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-6">
					<button type="submit" class="btn btn-success btn-block">确认修改</button>
				</div>
			</div>
		</form>
	</div>