<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="enterpriseHomePage.jsp"%>


	<div id="page-main" style="backgroud:#104d74;">
			<h2 class="text-info">编辑项目</h2><hr>
			
			<form action="${pageContext.request.contextPath }/enterprise/updateProject.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pid" value="${project.pid }">
			<input type="hidden" name="attachment" value="${project.attachment }">
			
			<div class="form-group row">
				<label for="password" class="col-sm-2 control-label">项目名称：</label>
				<div class="col-sm-5">
					<input required name="pname" type="text" class="form-control" value="${project.pname }">
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 control-label">项目描述：</label>
				<div class="col-sm-5">
					<input required name="description" type="text" class="form-control" value="${project.description }">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="attachment" class="col-sm-2 control-label">上传附件：</label>
				<div class="col-sm-5">
					<input name="file" type="file" id="attachment">
				</div>
			</div>
			
			<div class="col-sm-7">
			<button type="submit" class="btn btn-success btn-block btn-lg">编辑</button>
			</div>
		</form>
	</div>