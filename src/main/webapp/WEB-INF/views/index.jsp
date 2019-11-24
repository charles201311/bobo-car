
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
		<h1 align="center">已发布的汽车</h1>
		<a href="/add">去发布</a> <a href="/reg">去注册</a> <a href="/login">去登录</a> <a
			href="/driver/cars">我要租车</a>
		<hr>

		<c:forEach items="${cars}" var="c">
			<div style="float: left; margin-right: 5px">
				<dl>

					<dd>
						<img alt="" src="/pic/${c.picUrl }">
					</dd>
					<dd>品牌:${c.trademark }</dd>
					<dd>
						租金:<font color="red"> ${c.rent } 元</font>
					</dd>

				</dl>

			</div>

		</c:forEach>


	</div>
</body>
</html>