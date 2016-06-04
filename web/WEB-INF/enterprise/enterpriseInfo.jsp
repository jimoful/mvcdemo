<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="enterpriseHomePage.jsp" %>


<div id="page-main" style="backgroud:#104d74;">
	
	
	
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<h3 class="h3">查看企业简介：</h3>
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>企业名称：</span>
				<span class="text-info">${enterprise.name }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>企业邮箱：</span>
				<span class="text-info">${enterprise.email }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>企业联系人：</span>
				<span class="text-info">${enterprise.username }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>联系电话：</span>
				<span class="text-info">${enterprise.phone }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>企业描述：</span>
				<span class="text-info">${enterprise.description }</span>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-2">
				<span>企业地址：</span>
				<span class="text-info">${enterprise.address }</span>
				<hr />
			</div>
		</div>
	
	
</div>