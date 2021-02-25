package com.spring.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"", "/"})
	public String index() {
		//System.out.println("로그인 사용자 아이디 : " + principal.getUsername());
		return "index";
	}
	
	// USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
