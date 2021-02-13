package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.blog.model.User;

// 자동으로 bean 등록이 되므로 @Repository 의 생략이 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	// SELECT * FROM user WHERE username=? AND password=?;
	User findByUsernameAndPassword(String username, String password);

	// @Query(value="SELECT * FROM user WHERE username=? AND password=?", nativeQuery=true)
	// User login(String username, String password);
}
