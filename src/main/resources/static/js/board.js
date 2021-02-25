let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
		/*
		$("#btn-login").on("click", ()=>{
			this.login();
		});
		*/
	},
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};
		
		// ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8",
			dataType: "json"  
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	/*
	login: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};
		
		//console.log(data);
		
		// ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8",
			dataType: "json"  
		}).done(function(resp){
			alert("로그인 성공");
			location.href = "/";
		}).fail(function(error){
			//alert(JSON.stringify(error));
			alert("로그인 실패");
		}); 
	}
	*/
}

index.init();