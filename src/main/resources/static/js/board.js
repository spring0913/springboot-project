let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});

		$("#btn-update").on("click", () => {
			this.update();
		});
	},
	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");

		// ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), // http body 데이터
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	deleteById: function() {
		let id = $("#id").text();

		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");

		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			dataType: "json"
		}).done(function(resp) {
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	update: function() {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");

		$.ajax({
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data),
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init();