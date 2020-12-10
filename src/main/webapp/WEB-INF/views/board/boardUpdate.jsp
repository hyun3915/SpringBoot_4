<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../template/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h3>BoardWrite V1</h3>
		<p>The .navbar-right class is used to right-align navigation bar buttons.</p>
	
		<form action="./noticeUpdate" method="post" enctype="multipart/form-data">
		    <div class="form-group">
				<label for="title">Title:</label>
				<input type="text" class="form-control" id="title" value="${vo.title}" name="title" required="required">
		    </div>
		    <div class="form-group">
			 	<label for="writer">Writer:</label>
	     		<input type="text" class="form-control" id="writer" value="${member.id}" readonly="readonly" name="writer" required="required">
		    </div>
	  		<div class="form-group">
		    	<label for="contents">Contents:</label>
		    	<textarea class="form-control" rows="5" id="contents" name="contents">${vo.contents}</textarea>
		    </div>
		    <div class="form-group">
				<label for="files">File:</label>
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
		    </div>
		    
		    
		    <input type="hidden" id="num" name="num" value="${vo.num}">
			<input type="button" id="exit" class="btn btn-default" value="취소">
			<button type="submit" class="btn btn-info">수정</button>
	  	</form>
	  
	</div>

<script type="text/javascript">

	$('#contents').summernote({
	    height: 300
	});
	
	$('#contents').summernote('code','${vo.contents}');

	$("#exit").click(function(){
		location.href="./noticeList";
	});
	
</script>

</body>
</html>