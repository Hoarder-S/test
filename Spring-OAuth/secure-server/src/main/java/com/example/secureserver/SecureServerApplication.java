package com.example.secureserver;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureServerApplication.class, args);
	}
	
	 @EnableGlobalMethodSecurity(prePostEnabled = true)
	    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
	        protected void configure(final HttpSecurity http) throws Exception {
	            http.authorizeRequests()
	                    .anyRequest().authenticated()
	                    .and()
	                    .oauth2ResourceServer().jwt();
	        }
	    }

	    @RestController
	    public class RequestController {
	        @PreAuthorize("hasAuthority('SCOPE_mod_custom')")
	        @GetMapping("/")
	        public String getMessage(Principal principal) {
	            return "Welcome, " + principal.getName();
	        }
	    }


}
