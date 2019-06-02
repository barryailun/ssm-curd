<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径 -->
<script src="${APP_PATH }/static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CURD</h1>
			</div>
		</div>
		<div class="row">
		</div>
		<div class="row">
		</div>
		<div class="row">
		</div>
	</div>
</body>
</html>