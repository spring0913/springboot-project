<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<div class="container">
	<form>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		<div class="form-group">
			<label for="username">Username</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="pwd">Password</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>	
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>