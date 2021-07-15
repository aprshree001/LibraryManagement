package com.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {    
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests() .antMatchers("/").permitAll()
	 * .antMatchers("/img/**").permitAll() .anyRequest().authenticated(); }
	 */
    
	@Autowired
	private User userDetailService;
    
    
    
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
    	
    auth.userDetailsService(userDetailsService);
    }  

    
    
}
