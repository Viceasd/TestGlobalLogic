package com.example.testgloballogic;

import com.example.testgloballogic.model.User;
import com.example.testgloballogic.repository.UserRepository;
import com.example.testgloballogic.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestGlobalLogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGlobalLogicApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable();
			http.headers().frameOptions().disable();

/*
			http.authorizeRequests().antMatchers("/login").permitAll().and()
					.authorizeRequests().antMatchers("/h2-console/**").permitAll();

			http.csrf().disable();
			http.headers().frameOptions().disable(); */
            /*
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/login").permitAll()
					.anyRequest().authenticated();

         */
		}
	}

}
