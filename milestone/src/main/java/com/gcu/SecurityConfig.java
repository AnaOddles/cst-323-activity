// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.SpringSecurityBusinessService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Autowire Objects
	@Autowired 
	PasswordEncoder passwordEncoder; 
	
	@Autowired
	SpringSecurityBusinessService service; 
	
	/**
	 * Bean
	 * 
	 * @return BCryptPasswordEncoder
	 */
	@Bean 
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Method to configure authentication and security settings
	 * 
	 * 
	 * @param void
	 * 
	 * @return http (HttpSecurity)
	 * @throws Exception
	 * 
	 */
	//Configure spring security configuration
	@Override 
	protected void configure(HttpSecurity http) throws Exception
	{
		// Set configuration
		http.csrf().disable()
		//Security configuration for API - http basic
		.httpBasic()
			.and()
			.authorizeRequests()
				//Secure URI paths with /service
				.antMatchers("/service/**").authenticated()
				.and()
		.authorizeRequests()
			.antMatchers("/login/", "/register/**").permitAll() //Pages that are accessible to all
			.anyRequest().authenticated()
			.and()
			//Security configuration for authentication
		.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error") //Forward after failed login attempt
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.defaultSuccessUrl("/myproducts/", true) //Forward after successful login attempt
			.and()
		.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutSuccessUrl("/");				
				
	}
	
	/**
	 * Method to configure aauthentication builder
	 * 
	 * 
	 * @param void
	 * 
	 * @return auth (AuthenticationManagerBuilder)
	 * @throws Exception
	 * 
	 */
	@Autowired 
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		//Configure the authentication service and bind to AuthenticationManagerBuilder
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);	
	}
}
