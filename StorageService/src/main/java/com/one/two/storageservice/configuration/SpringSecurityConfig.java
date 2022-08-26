package com.one.two.storageservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
                        .antMatchers(HttpMethod.GET, "/", "/storages**", "/storages/*").permitAll()
                        .anyRequest().authenticated())
                //.anyRequest().authenticated()
                //.and()
                .oauth2Login();
    }
}
