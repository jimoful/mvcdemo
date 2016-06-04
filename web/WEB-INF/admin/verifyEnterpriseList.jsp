<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">


<h2 class="text-info">企业列表</h2><hr>
	
	<div class="row">
		<div class="col-md-10">
			<table class="table table-bordered">
			<tr>
					<td>企业名称</td>
					<td>通过审核</td>
			</tr>
			
			<c:forEach items="${pageBean.list }" var="ent">
					
				
				<tr>
					<td><a href="${pageContext.request.contextPath }/admin/getEnterpriseInfo.do?eid=${ent.eid}">${ent.name }</a></td>
					<td><a href="${pageContext.request.contextPath }/admin/verifyEnterprise.do?eid=${ent.eid}">通过审核</a></td>
				</tr>
			</c:forEach>
			</table>
			<hr>
		</div>
	</div>
	
</div>