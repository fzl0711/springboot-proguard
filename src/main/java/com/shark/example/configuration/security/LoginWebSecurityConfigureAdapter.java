package com.shark.example.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static com.shark.example.configuration.security.SecurityConfiguration.AUTH_URL;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration("LoginWebSecurityConfigureAdapter")
public class LoginWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers(POST,AUTH_URL + "/register").permitAll()
                .antMatchers(POST,AUTH_URL + "/login").permitAll()
                .antMatchers(GET, "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new LoginAuthenticationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(STATELESS);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(GET, "/swagger-ui.html")
                .antMatchers(GET, "/swagger-resources/**")
                .antMatchers(GET, "/v2/**")
                .antMatchers(GET, "/webjars/**");
    }
}
