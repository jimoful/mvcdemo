<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="enterpriseHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">


<h2 class="text-info">查看学生提交的项目</h2><hr>
	



	
	<c:forEach items="${sps }" var="sp">
	
	
	<div class="row">
		<div class="col-md-10">
			<form action="${pageContext.request.contextPath }/enterprise/praiseProject.do" method="post">
			<input type="hidden" name="spid" value="${sp.spid }"/>
			<input type="hidden" name="pid" value="${sp.project.pid }"/>
				<table class="table table-striped">
					
					<tr>
						<td>提交学生</td>
						<td>${sp.student.name }（${sp.student.sno }）</td>
					</tr>
					<tr>
						<td>上传的项目</td>
						<td><a href="${pageContext.request.contextPath }/util/download.do?fileName=${sp.submitPath}">${sp.submitPath }</a>
					</tr>
					
					<tr>
						<td>提交次数</td>
						<td>第${sp.submitNumber }次</td>
					</tr>
					
					<tr>
						<td>提交时间</td>
						<td>${sp.submitTime }</td>
					</tr>
					
					<tr>
						<td>评价</td>
						<td class="text-danger"><textarea name="praise" rows="5" class="form-control">${sp.praise }</textarea></td>
					</tr>
					
					<tr>
						<td colspan="2"><button type="submit" class="btn btn-success pull-right">提交评价</button></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>
	</c:forEach>
</div>