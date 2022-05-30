package com.argentinaprograma.portfolio;

import com.argentinaprograma.portfolio.Security.Jwt.JwtEntryPoint;
import com.argentinaprograma.portfolio.Security.Jwt.JwtTokenFilter;
import com.argentinaprograma.portfolio.Service.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class PortfolioApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)

	public class MainSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		UserDetailsServiceImpl userDetailsService;

		@Autowired
		JwtEntryPoint jwtEntryPoint;

		@Bean
		public JwtTokenFilter jwtTokenFilter(){
			return new JwtTokenFilter();
		}

		@Bean
		public PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Override
		protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
					.exceptionHandling()
					.authenticationEntryPoint(jwtEntryPoint)
					.and()
					.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").permitAll()
					.antMatchers("/auth/**").permitAll()
					.anyRequest()
					.authenticated();
			http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		}}
}
