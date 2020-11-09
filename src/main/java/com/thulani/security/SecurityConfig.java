package com.thulani.security;

import com.thulani.entity.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("staff").password("2000217").roles(ADMIN_ROLE)
                .and()
                .withUser("student").password("2171000").roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
// Admin Roles
                .authorizeRequests().antMatchers(HttpMethod.GET, "**/read/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "**/delete/**").hasRole(ADMIN_ROLE)
// User Roles
                .antMatchers(HttpMethod.POST, "**/create").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "**/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "**/update/**").hasRole(USER_ROLE)

                .and().csrf().disable().formLogin().disable();

    }
}
