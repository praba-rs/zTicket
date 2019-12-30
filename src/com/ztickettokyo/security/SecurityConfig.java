package com.ztickettokyo.security;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        auth.inMemoryAuthentication()
        .withUser("user").password("{noop}123456").roles("USER")
        .and()
        .withUser("admin").password("{noop}123456").roles("USER", "ADMIN");*/
        
        
		
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select loginname,CONCAT('{noop}',password),1 "
	        + "from appuser "
	        + "where loginname = ?")
	      .authoritiesByUsernameQuery("select u.loginname,r.name "
	        + "from approle r, appuser u "
	        + "where r.role_id=u.role_id and u.loginname = ?");
    }
 
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*        http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/area/**").hasRole("ADMIN")
        .antMatchers("/**").hasAnyRole("ADMIN", "USER")
        .and().formLogin()
        .and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();*/
        
        
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/register/**").permitAll()
		.antMatchers( "/area/**").access("hasRole('EVENTADMIN')")
		.antMatchers( "/eventmaster/**").access("hasAnyRole('EVENTADMIN','APPADMIN')")
		.antMatchers( "/role/**").access("hasRole('EVENTADMIN')")
		.antMatchers( "/user/**").access("hasAnyRole('EVENTADMIN','APPADMIN')")
		.antMatchers( "/test/**").access("hasAnyRole('EVENTADMIN','APPADMIN')")
		.and().exceptionHandling().accessDeniedPage("/accessDenied")
		.and().formLogin();
        
    }
}