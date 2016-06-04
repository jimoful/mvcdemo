<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="studentHomePage.jsp"%>




<div id="page-main" style="backgroud:#104d74;">


<h2 class="text-info">项目列表</h2><hr>

<div class="row">
	<div class="col-md-10">
    <div class="input-group">
      <input id="findValue" type="text" class="form-control" placeholder="搜索项目...">
      <span class="input-group-btn">
        <a id="find" class="btn btn-default" href="#">搜索项目</a>
      </span>
  	</div>
  	<hr>
	</div>
</div>
<c:forEach items="${pageBean.list }" var="pro">


	<div class="row">	
		<div class="col-md-10">
			<form action="${pageContext.request.contextPath }/student/uploadProject.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pid" value="${pro.pid }">
			<table class="table table-bordered">
					<tr>
                        <td>项目名称</td>
                        <td colspan="3">${pro.pname}</td>
                    </tr>
                    
                    <tr>
                        <td>发布企业</td>
                        <td colspan="3"><a href="${pageContext.request.contextPath }/student/findProjectListByEnterprise.do?eid=${pro.enterprise.eid }&page=1">${pro.enterprise.name }</a></td>
                    </tr>
                    <tr>
                        <td>发布日期</td>
                        <td colspan="3">${pro.publishTime }</td>
                    </tr>
                    <tr>
                        <td>下载附件</td>
                        <td colspan="3"><a href="${pageContext.request.contextPath }/util/download.do?fileName=${pro.attachment }">${pro.attachment }</a></td>
                    </tr>
                    <tr>
                        <td>项目描述</td>
                        <td colspan="3">
							${pro.description }
						</td>
                    </tr>
                    
                    <tr>
                        <td><button class="btn btn-success btn-sm" type="submit">上传</button></td>
                        <td colspan="3">
							<input required type="file" name="file"/>
						</td>
                    </tr>
			</table>
			<hr>
			</form>
		</div>
	</div>
	</c:forEach>
	
	
	<nav class="col-md-10 col-md-offset-2">
		<ul class="pagination">
<li><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=1">首页</a></li>

			<c:choose>
				<c:when test="${pageBean.curPage!=1 }">
					<li><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${pageBean.curPage-1 }"><span>&laquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&laquo;</span></li>
				</c:otherwise>
			</c:choose>
		
			<c:choose>
				<c:when test="${pageBean.allPage<=10 }">
					<c:forEach begin="1" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.curPage<=5 }">
					<c:forEach begin="1" end="10" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${pageBean.allPage-pageBean.curPage<5 }">
					<c:forEach begin="${pageBean.allPage-9 }" end="${ pageBean.allPage}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${i }">${i }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${pageBean.curPage-4 }" end="${ pageBean.curPage+5}" var="i">
						<li class="pageNum"><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${i }">${i }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageBean.curPage!=pageBean.allPage }">
					<li><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${pageBean.curPage+1 }"><span>&raquo;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><span>&raquo;</span></li>
				</c:otherwise>
			</c:choose>

			<li><a href="${pageContext.request.contextPath }/student/findProjectListByPname.do?pname=${pname}&page=${pageBean.allPage}">尾页</a></li>
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
			$(this).attr("href","${pageContext.request.contextPath }/student/findProjectListByPname.do?pname="+findValue+"&page=1");
		});
		
	});

</script>