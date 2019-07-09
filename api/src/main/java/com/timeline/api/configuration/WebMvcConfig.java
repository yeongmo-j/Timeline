package com.timeline.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.timeline.api.interceptor.AuthenticationInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	
	//인터셉터에선 빈을 주입받을 수 없으므로 여기서 만들어서 아래 메소드에서 추가해 줌 
	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
				.addPathPatterns("/**")
                .excludePathPatterns("/login", "/regist", "/photo/**"); //article은 테스트 위해 임시
                //로그인 쪽은 예외처리를 한다.
    }
}
