package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.RelativeRedirectFilter;

@Configuration
public class AppConfig {
    // N.B. comment out the following bean, then it works fine.
    @Bean
    public FilterRegistrationBean<RelativeRedirectFilter> relativeRedirectFilter() {
        FilterRegistrationBean<RelativeRedirectFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RelativeRedirectFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<ErrorPageFilter> errorPageFilter() {
        FilterRegistrationBean<ErrorPageFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ErrorPageFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        return registrationBean;
    }
}
