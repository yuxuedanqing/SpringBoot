package com.mkydy.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @ClassName Role
 * @Description: 角色  
 * @author: Hll  
 * @since: 2019年6月23日 下午1:50:20
 */
@Data
@AllArgsConstructor
public class Role {

	private Integer rid;
	private String name;
	private Set<Permission> permission = new HashSet<>();
	private Set<User> user = new HashSet<>();
}
