package com.mkydy.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {

	private Integer uid;
	
	private String username;
	
	private String password;
	
	private Set<Role> roles = new HashSet<>();
}
