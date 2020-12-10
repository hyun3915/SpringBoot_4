<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- session > memberVO > roles -->
	
	<h1>${sessionScope.member.roles[0].role}</h1>
	<c:forEach items="${member.roles}" var="memberRoleVO">
		<h1>${memberRoleVO.role}</h1>
	</c:forEach>
	
</div>
	
</body>
</html>