<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Member Join Page</h3>
	
  <form:form modelAttribute="memberVO" enctype="multipart/form-data">
  	<div class="form-group">
      	<label for="id">ID:</label>
      	<!-- path : parameter Name -->
      	<form:input path="id" class="form-control"/>
      	<form:errors path="id" cssClass="error"></form:errors>
    </div>
    
    <div class="form-group">
      <label for="pw">PW:</label>
      <form:password path="pw" class="form-control"/>
      <form:errors path="pw" cssClass="error"></form:errors>
    </div>
    
  	<div class="form-group">
      	<label for="name">NAME:</label>
      	<!-- path : parameter Name -->
      	<form:input path="name" class="form-control"/>
      	<form:errors path="name" cssClass="error"></form:errors>
    </div>
    
  	<div class="form-group">
      	<label for="age">AGE:</label>
      	<!-- path : parameter Name -->
      	<form:input path="age" class="form-control"/>
      	<form:errors path="age" cssClass="error"></form:errors>
    </div>
    
  	<div class="form-group">
      	<label for="email">EMAIL:</label>
      	<!-- path : parameter Name -->
      	<form:input path="email" class="form-control"/>
      	<form:errors path="email" cssClass="error"></form:errors>
    </div>
    
    <button type="submit" class="btn btn-default">Join</button>    
    
  </form:form>
  
</div>

<script type="text/javascript">

</script>

</body>
</html>