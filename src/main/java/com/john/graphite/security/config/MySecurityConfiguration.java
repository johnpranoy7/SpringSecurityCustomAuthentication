package com.john.graphite.security.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration {

	@Autowired
	private JwtTokenFilter jwtTokenFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello").permitAll().anyRequest().authenticated();
//		http.authorizeHttpRequests(authorize -> authorize.antMatchers("/resources/**", "/signup", "/about").permitAll()
//				.anyRequest().denyAll());

		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
				}).and().authorizeRequests().antMatchers("/world").permitAll().anyRequest().authenticated();
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		// http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated());
		return http.build();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}