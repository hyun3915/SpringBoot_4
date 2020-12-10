<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>Board List Page V1</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  
  <c:if test="${not empty member}">
  <h1>Member Login Message : <spring:message code="member.login.message" arguments="${member.id}"></spring:message></h1>
  </c:if>
  <img alt="" src="../images/kimsh.jpeg">
  
<!-- search -->
<form action="./${board}List" id="frm">
	<input type="hidden" name="curPage" id="curPage" value=1>
	<div class="form-group">
	<label for="sel1">Select list:</label>
	
	<select class="form-control" id="kind" name="kind">
		<option>title</option>
		<option>writer</option>
		<option>contents</option>
	</select>	
	</div>
	
	<div class="input-group">
    <input type="text" class="form-control" placeholder="Search" id="search" name="search">
    	<div class="input-group-btn">
    	  <button class="btn btn-default" type="submit">
    	    <i class="glyphicon glyphicon-search"></i>
    	  </button>
    	</div>
    </div>	
</form>
 
  <table class="table table-hover">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	
  	<c:forEach items="${list}" var="vo">
  		<tr>
  			<td>${vo.num}</td>
  			<td><a href="${board}Select?num=${vo.num}">${vo.title}</a></td>
  			<td>${vo.writer}</td>
  			<td>${vo.regDate}</td>
  			<td>${vo.hit}</td>
  		</tr>
  	</c:forEach>
  	
  </table>
  
  <!-- Page -->
	<ul class="pagination">
		<c:if test="${pager.before}">
			<li><a href="#" class="list" title="${pager.startNum-1}">이전</a></li>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li><a href="#" class="list" title="${i}">${i}</a></li>
		</c:forEach>
		<c:if test="${pager.after}">
			<li><a href="#" class="list" title="${pager.lastNum+1}">다음</a></li>
		</c:if>
	</ul>
  
  <!-- Write 버튼 생성 클릭 -->
  <button id="btn">Write</button>		<!-- Form태그 내에서는 submit event가 실행 -->
  <input type="submit" value="Write">	<!-- Form태그 내에서는 submit event가 실행 -->
  <input type="button" value="Write">	<!-- 그냥 버튼 -->
</div>

  <script type="text/javascript">

	//$(dQocument).ready(function(){	//HTML 문서가 로딩이 끝났을 때
	
	$("#search").val('${param.search}');
	var kind = '${param.kind}';
	if(kind != ''){
	$("#kind").val('${param.kind}');
	}
	
	//$(function(){	//document.ready의 축약형
	$("#btn").click(function(){
		location.href="./${board}Write";
	});

	$(".list").click(function(){
		var curPage = $(this).attr("title");
		$("#curPage").val(curPage);
		
		$("#frm").submit();
	});	
	
	
  </script>
</body>
</html>