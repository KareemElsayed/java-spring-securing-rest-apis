package io.jzheaux.springsecurity.resolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import static org.springframework.http.HttpMethod.GET;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(prePostEnabled = true) @SpringBootApplication public class ResolutionsApplication extends WebSecurityConfigurerAdapter {

	@Bean UserDetailsService userDetailsService(UserRepository users) {
		return new UserRepositoryUserDetailsService(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(ResolutionsApplication.class, args);
	}

	@Override protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authz -> authz.anyRequest().authenticated()).httpBasic(basic -> {
		});
	}

}
