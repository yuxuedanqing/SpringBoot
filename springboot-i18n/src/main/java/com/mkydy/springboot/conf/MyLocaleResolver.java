package com.mkydy.springboot.conf;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
/**
 * 
 * @ClassName MyLocaleResolver
 * @Description: 国际化处理器 
 * @author: Hll  
 * @since: 2019年6月9日 上午10:43:33
 */
public class MyLocaleResolver implements LocaleResolver {

	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		// 默认获取系统语言环境
		Locale locale = Locale.getDefault();
		if(!StringUtils.isEmpty(l)) {
			String[] s = l.split("_");
			locale = new Locale(s[0], s[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		
	}

}
