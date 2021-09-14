package com.example.item.config;

import com.example.item.security.CustomJSONLoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterAt(new CustomJSONLoginFilter("/login"), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }

}
