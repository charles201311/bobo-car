<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>


</head>
<body>
	<div class="container">
		<h1>用户登录</h1>
		<hr>
		<span style="color: red">${message }</span>
		<form action="/login" method="post">
			<div class="form-group">
				<label>手机号码:</label> <input class="form-control" type="text"
					name="phone">
			</div>
			<div class="form-group">
				<label>登录密码:</label> <input class="form-control" type="password"
					name="password">
			</div>
		
			<div class="form-group">
				<button class="btn btn-info" type="submit">登录</button>
			</div>
		</form>


	</div>

	<script type="text/javascript">
	
	$(function(){
		
		$.get("/selectTypes",function(list){
			for(var i in list ){
				$("#driveType").append("<option value='"+list[i].code+"'>"+list[i].code+"</option>")
			}
		});
		
		
		
	})
	
	
	</script>
</body>
</html>