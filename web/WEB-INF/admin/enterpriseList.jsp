<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="adminHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">


<h2 class="text-info">企业列表</h2><hr>
	
	<div class="row">
		<div class="col-md-10">
			<table class="table table-bordered">
				<tr>
					<td>企业名称</td>
					<td>删除</td>
				</tr>
				
				<c:forEach items="${pageBean.list }" var="ent">
					
				
				<tr>
					<td><a href="${pageContext.request.contextPath }/admin/getEnterpriseInfo.do?eid=${ent.eid}">${ent.name }</a></td>
					<td><a href="${pageContext.request.contextPath }/admin/deleteEnterprise.do?eid=${ent.eid}">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<hr>
		</div>
	</div>
	
	
<nav class="col-md-10 col-md-offset-2">
		<ul class="pagination">
<li><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=1">首页</a></li>

			<c:choose>
				<c:when test="${pageBean.curPage!=1 }">
					<li><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${pageBean.curPage-1 }"><span>&laquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&laquo;</span></li>
				</c:otherwise>
			</c:choose>
		
			<c:choose>
				<c:when test="${pageBean.allPage<=10 }">
					<c:forEach begin="1" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.curPage<=5 }">
					<c:forEach begin="1" end="10" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.allPage-pageBean.curPage<5 }">
					<c:forEach begin="${pageBean.allPage-9 }" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${pageBean.curPage-4 }" end="${ pageBean.curPage+5}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageBean.curPage!=pageBean.allPage }">
					<li><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${pageBean.curPage+1 }"><span>&raquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&raquo;</span></li>
				</c:otherwise>
			</c:choose>

			<li><a href="${pageContext.request.contextPath }/admin/findAllEnterpriseList.do?page=${pageBean.allPage}">尾页</a></li>
		</ul>
	</nav>
	
</div>


<script type="text/javascript">
	$(function(){
		var curPage = ${pageBean.curPage};
		$(".pageNum").each(function(){
			if($(this).text()==curPage){
				$(this).addClass("active");
			}
		});
	});

</script>