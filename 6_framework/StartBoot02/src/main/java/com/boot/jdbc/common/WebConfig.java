package com.boot.jdbc.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//이번엔 필터처럼 내부에 생성하지 않고 외부에 생성!
		registry.addInterceptor(new CheckInterceptor())
				.addPathPatterns("/myboard/**") // 인터셉터를 거쳐 적용시킬 경로 ** 이렇게 적으면 /myboard/insert/test 이런 식으로 하위 단계까지 추가적으로 확인 가능.
				.excludePathPatterns("/myboard/test"); // 이 경우에는 제외한다.
	}
}
