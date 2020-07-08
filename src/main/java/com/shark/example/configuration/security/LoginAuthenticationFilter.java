package com.shark.example.configuration.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LoginAuthenticationFilter extends BasicAuthenticationFilter {

    public LoginAuthenticationFilter(AuthenticationManager manager) {
        super(manager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConfiguration.ACCESS_HEADER);
        if (!StringUtils.isEmpty(header)) {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            // parse token to get user id
            Long userId = Long.valueOf(
                    Jwts.parser()
                            .setSigningKey(SecurityConfiguration.ACCESS_SECRET.getBytes())
                            .parseClaimsJws(token)
                            .getBody()
                            .getSubject());
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(userId, null, authorities);
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                log.warn(e.getLocalizedMessage());
            } else {
                e.printStackTrace();
            }
        }
        // no Authentication will cause 401
        return null;
    }
}
