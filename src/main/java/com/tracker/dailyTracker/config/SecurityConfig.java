package com.tracker.dailyTracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
	        .csrf().disable()
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // ⬅️ Allow OPTIONS
	            .requestMatchers("/api/public/**").permitAll()
	            .requestMatchers("/api/auth/register").permitAll()// ⬅️ Public APIs if any
	            .anyRequest().authenticated()
	        )
	        .httpBasic(); // or .formLogin(), or JWT filters depending on your auth method

	    return http.build();
    }

	@Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
            .username("admin")
            
            .password(passwordEncoder().encode("password123"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	



}
