package com.ly.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCrosConfig {
    @Bean
    public CorsFilter corsFilter(){
        //添加cros的配置信息
        CorsConfiguration config=new CorsConfiguration();
        //允许的域
        config.addAllowedOrigin("http://localhost:9001");
        //2是否发送cookie信息
        config.setAllowCredentials(true);
        //3允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        //4允许的头信息
        config.addAllowedHeader("*");
        //5有效时长
        config.setMaxAge(3600l);
        //2添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configurationSource =new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",config);
        //3返回新的Corsfilter
        return new CorsFilter(configurationSource);

    }
}
