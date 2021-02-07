package com.spring.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java Object 를 테이블로 매핑해주는 기술
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DynamicInsert // insert 시에 null 인 필드를 제외시켜줌
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB 의 넘버링 전략을 따라감
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 100) // 비밀번호를 해쉬값으로 저장
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("user")
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp // 시간이 자동으로 입력됨
	private Timestamp createDate;
}
