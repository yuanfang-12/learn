package com.bocsoft.Configrution;

import com.bocsoft.filter.FilterDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class OverLoad implements WebMvcConfigurer {


    @Bean
    public FilterDemo filterDemo(){
        return new FilterDemo();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(filterDemo());
    }
}
