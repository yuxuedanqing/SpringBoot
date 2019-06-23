package com.mkydy.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @ClassName Permission
 * @Description: 权限  
 * @author: Hll  
 * @since: 2019年6月23日 下午1:47:13
 */
@Data
@AllArgsConstructor
public class Permission {

	private Integer pid;
	
	private String name;
	
	private String url;
}
