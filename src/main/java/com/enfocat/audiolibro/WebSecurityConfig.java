package com.enfocat.audiolibro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/story/addStory/**","/challenges/addchallenge","/chapter/addchapter/**","/comments/addComment/**")
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
        
        /*http
            .authorizeRequests()
            .antMatchers("/uploadFile", "/css/**","/resources/**", "/images/**","/registration","/home","/search","/storyRead","/registro","/mailBox","/story/search", "/")
            .permitAll()//acceso sin loguear de vistas
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();*/
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //             .authorizeRequests()
    //                 .antMatchers("/uploadFile","/", "/uploadMultipleFiles", "/downloadFile/**", "/css/**","/resources/**", "/images/**","/registration","/home","/search","/storyRead","/registro","/mailBox")
    //                     .permitAll()
    //                 .anyRequest()
    //                     .authenticated();
    // }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}