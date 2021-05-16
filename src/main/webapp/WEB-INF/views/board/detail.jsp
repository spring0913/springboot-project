<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<div class="container">
	<div>
		글 번호 : <span id="id"><i>${board.id} </i></span>
		| 작성자 : <span><i>${board.user.username} </i></span>
	</div>
	<br>
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr/>
	<div>
  		<div>${board.content}</div>
  	</div>
  	<hr/>
  	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
  	<c:if test="${board.user.id == principal.user.id}">
  	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
  		<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br> <br>
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>