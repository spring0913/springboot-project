package com.spring.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.blog.model.Board;
import com.spring.blog.model.User;

// 자동으로 bean 등록이 되므로 @Repository 의 생략이 가능
public interface BoardRepository extends JpaRepository<Board, Integer> {

}