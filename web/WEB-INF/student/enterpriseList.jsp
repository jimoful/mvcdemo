<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="studentHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">




	<h2 class="text-info">企业列表</h2>
	<hr>


	<div class="row">
		<div class="col-md-10">
			<div class="input-group">
				<input id="findValue" type="text" class="form-control" placeholder="搜索企业...">
				<span class="input-group-btn">
					<a id="find" href="#" class="btn btn-default">搜索企业</a></span>
			</div>
			<hr>
		</div>
	</div>



	<div class="row">
		<div class="col-md-10">
			<table class="table table-bordered">
				<tr>
					<td>企业名称</td>
					<td>取消关注</td>
				</tr>
				
				<c:forEach items="${pageBean.list}" var="ent">
					<tr>
						<td><a href="${pageContext.request.contextPath }/student/findProjectListByEnterprise.do?eid=${ent.eid }&page=1">${ent.name }</a></td>
						<td><a
							href="${pageContext.request.contextPath }/student/followEnterprise.do?sid=${sessionScope.student.sid }&eid=${ent.eid}"
							class="btn btn-success">关注</a></td>
					</tr>
				</c:forEach>
			</table>
			<hr>
		</div>
	</div>


	<nav class="col-md-10 col-md-offset-2">
		<ul class="pagination">
<li><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=1">首页</a></li>

			<c:choose>
				<c:when test="${pageBean.curPage!=1 }">
					<li><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${pageBean.curPage-1 }"><span>&laquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&laquo;</span></li>
				</c:otherwise>
			</c:choose>
		
			<c:choose>
				<c:when test="${pageBean.allPage<=10 }">
					<c:forEach begin="1" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.curPage<=5 }">
					<c:forEach begin="1" end="10" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.allPage-pageBean.curPage<5 }">
					<c:forEach begin="${pageBean.allPage-9 }" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${pageBean.curPage-4 }" end="${ pageBean.curPage+5}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageBean.curPage!=pageBean.allPage }">
					<li><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${pageBean.curPage+1 }"><span>&raquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&raquo;</span></li>
				</c:otherwise>
			</c:choose>

			<li><a href="${pageContext.request.contextPath }/student/findEnterpriseList.do?page=${pageBean.allPage}">尾页</a></li>
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
		
		$("#find").click(function(){
			var findValue = $("#findValue").val();
			$(this).attr("href","${pageContext.request.contextPath }/student/findEnterpriseListByName.do?name="+findValue+"&page=1");
		});
		
	});

</script>