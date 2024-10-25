package com.Joonggodeal.joonggodeal.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("https://web-smartlicense-1272llwyzbyro.sel5.cloudtype.app")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST");
//                .allowedHeaders("*")
//                .allowCredentials(true);
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//        interceptorRegistry.addInterceptor(new AuthenticationInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/memberLogin/verify","/memberLogin/logout", "/memberLogin/guestLogin");
//    }


}
