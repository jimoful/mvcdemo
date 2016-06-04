<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="enterpriseHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">


		<div class="row">
			<div class="col-sm-4 ">
				<h3 class="h3">学生列表：</h3>
				<hr />
			</div>
		</div>
	
	<div class="row">
		<div class="col-md-10">
			<table class="table table-bordered">
			
			
				<tr>
					<td>学号</td>
					<td>姓名</td>
					<td>关注</td>
				</tr>
				<c:forEach items="${pageBean.list }" var="stu" >
					<tr>
						<td><a href="${pageContext.request.contextPath }/enterprise/getStudentInfo.do?sid=${stu.sid}">${stu.sno }</a></td>
						<td>${stu.name }</td>
						<td><a href="${pageContext.request.contextPath }/enterprise/followStudent.do?eid=${sessionScope.enterprise.eid }&sid=${stu.sid}" class="btn btn-success">关注</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<nav class="col-md-10 col-md-offset-2">
		<ul class="pagination">

			<li><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=1">首页</a></li>

			<c:choose>
				<c:when test="${pageBean.curPage!=1 }">
					<li><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${pageBean.curPage-1 }"><span>&laquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&laquo;</span></li>
				</c:otherwise>
			</c:choose>
		
			<c:choose>
				<c:when test="${pageBean.allPage<=10 }">
					<c:forEach begin="1" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.curPage<=5 }">
					<c:forEach begin="1" end="10" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.allPage-pageBean.curPage<5 }">
					<c:forEach begin="${pageBean.allPage-9 }" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${pageBean.curPage-4 }" end="${ pageBean.curPage+5}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${i }">${i }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageBean.curPage!=pageBean.allPage }">
					<li><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${pageBean.curPage+1 }"><span>&raquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&raquo;</span></li>
				</c:otherwise>
			</c:choose>

			<li><a href="${pageContext.request.contextPath }/enterprise/findStudentList.do?page=${pageBean.allPage}">尾页</a></li>
		</ul>
	</nav>
	

</div>
<script type="text/javascript">
	$(function(){
		var curPage = <s:property value="${pageBean.curPage}"/>;
		$(".pageNum").each(function(){
			if($(this).text()==curPage){
				$(this).addClass("active");
			}
		});
	});

</script>