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
		<h1>发布车辆</h1>
		<hr>
		<form action="" id="form1">
			<div class="form-group">
				<label>车辆名称:</label> <input class="form-control" type="text"
					name="name">
			</div>
			<div class="form-group">
				<label>车辆品牌:</label> <input class="form-control" type="text"
					name="trademark">
			</div>
			<div class="form-group">
				<label>日租金:</label> <input class="form-control" type="text"
					name="rent">
			</div>
			<div class="form-group">
				<label>上传图片:</label> <input class="form-control" type="file"
					name="file">
			</div>
			<div class="form-group">
				<label>要求最低驾照:</label> <select id="carType" name="carType">
					<option>请选择</option>
				</select>
			</div>
			<div class="form-group">
				<button class="btn btn-info" onclick="add()" type="button">发布</button>
			</div>
		</form>


	</div>

	<script type="text/javascript">
	
	$(function(){
		
		$.get("/selectTypes",function(list){
			for(var i in list ){
				$("#carType").append("<option value='"+list[i].code+"'>"+list[i].code+"</option>")
			}
		});
		
		
		
	})
	
	
	 function add(){
		 var formData = new FormData($( "#form1" )[0]);
		 
		 $.ajax({
			 url : "/add",
			 type : 'POST',
			 data : formData,
			 // 告诉jQuery不要去处理发送的数据
			 processData : false,
			 // 告诉jQuery不要去设置Content-Type请求头
			 contentType : false,
			 success:function(flag){
				if(flag){
					alert("发布成功")
				}else{
					alert("发布失败")
				}
					
			 }
		 });
	 }
	
	
	</script>
</body>
</html>