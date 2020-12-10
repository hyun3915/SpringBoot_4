package com.sub.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sub.sb4.interceptor.CustomInterceptor;
import com.sub.sb4.interceptor.NoticeAdminInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 적용할 Interceptor를 등록
		registry.addInterceptor(customInterceptor)
		
		//Interceptor에서 사용할 URL 작성
		.addPathPatterns("/notice/**")
		//.addPathPatterns("/qna/**")
	
		//.addPathPatterns(patterns) 추가 가능
		
		//Interceptor에서 제외할 URL 작성
		.excludePathPatterns("/notice/noticeWrite");
		
		registry.addInterceptor(noticeAdminInterceptor)
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeUpdate")
		.addPathPatterns("/notice/noticeDelete");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
