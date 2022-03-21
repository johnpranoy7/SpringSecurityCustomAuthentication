package com.john.graphite.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.john.graphite.bean.MyUser;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
//	 private final JwtTokenUtil jwtTokenUtil;
//	    private final UserRepo userRepo;
//
//	    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil,
//	                          UserRepo userRepo) {
//	        this.jwtTokenUtil = jwtTokenUtil;
//	        this.userRepo = userRepo;
//	    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// Get authorization header and validate
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header.isEmpty() || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		// Get jwt token and validate
// 		final String token = header.split(" ")[1].trim();
//	    if (!jwtTokenUtil.validate(token)) {
		if (false) {
			chain.doFilter(request, response);
			return;
		}

		// Get user identity and set it on the spring security context
//	        UserDetails userDetails = userRepo
//	            .findByUsername(jwtTokenUtil.getUsername(token))
//	            .orElse(null);
//
//	        UsernamePasswordAuthenticationToken
//	            authentication = new UsernamePasswordAuthenticationToken(
//	                userDetails, null,
//	                userDetails == null ?
//	                    List.of() : userDetails.getAuthorities()
//	            );
//
//	        authentication.setDetails(
//	            new WebAuthenticationDetailsSource().buildDetails(request)
//	        );
//
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
		MyUser user = new MyUser("john", "myeamil.com", "1234");
		SecurityContextHolder.getContext().setAuthentication(null);
		chain.doFilter(request, response);
	}

}