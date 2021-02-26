package com.spring.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.blog.model.Board;
import com.spring.blog.model.RoleType;
import com.spring.blog.model.User;
import com.spring.blog.repository.BoardRepository;

// 스프링이 컴포넌트 스캔을 통해 Bean 에 등록 (IoC)
@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void write(Board board, User user) { // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	public Page<Board> boardList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
}
