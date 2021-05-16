<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<div class="container">
	<form>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		<div class="form-group">
			<label for="title">Title</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>
		<div class="form-group">
  			<label for="comment">Content:</label>
  			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
</div>

<script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>