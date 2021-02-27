package com.spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.blog.model.RoleType;
import com.spring.blog.model.User;
import com.spring.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해 Bean 에 등록 (IoC)
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public User findUser(String username) {
		User user = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		return user;
	}
	
	public int join(User user) {
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() "+e.getMessage());
		}
		return -1;
	}
	
	/*
	@Transactional(readOnly = true) // select 할 때 트랜잭션 시작, service 종료 시에 트랜잭션 종료(정합성)
	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	*/
}
