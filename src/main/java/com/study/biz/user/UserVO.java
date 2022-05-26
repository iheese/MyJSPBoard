package com.study.biz.user;

import lombok.Data;

// VO(Value Object) 클래스
@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	
	
}

