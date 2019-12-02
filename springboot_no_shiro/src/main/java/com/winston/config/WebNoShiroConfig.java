package com.winston.config;

import com.winston.interceptor.Logininterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebNoShiroConfig
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/2 14:22
 * @Version：
 */
@Configuration
public class WebNoShiroConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Logininterceptor logininterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logininterceptor).addPathPatterns("/web/**");
    }
}
