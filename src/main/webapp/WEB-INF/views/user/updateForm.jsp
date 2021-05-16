<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<div class="container">
	<form>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		<input type="hidden" id="id" value="${principal.user.id}" />
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly>
		</div>
		<div class="form-group">
			<label for="pwd">Password</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>	
	</form>
	<button id="btn-update" class="btn btn-primary">회원수정</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>