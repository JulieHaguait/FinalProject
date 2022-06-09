package finalProject.SkyBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
				http.antMatcher("/api/**")
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and()
						.csrf().ignoringAntMatchers("/api/**")
						.and()
						.authorizeHttpRequests()
							.antMatchers(HttpMethod.OPTIONS).permitAll()
							
							.antMatchers(HttpMethod.POST, "/api/auth/inscription").permitAll()
							.antMatchers(HttpMethod.GET, "/api/auth/login/**", "/api/auth/inscription").permitAll()
							
							.antMatchers(HttpMethod.GET, "/api/admin/**").hasRole("ADMIN")
							.antMatchers(HttpMethod.POST, "/api/admin/**", "/api/admin/createNode").hasRole("ADMIN")
							.antMatchers(HttpMethod.PATCH, "/api/admin/**").hasRole("ADMIN")
							.antMatchers(HttpMethod.PUT, "/api/admin/**").hasRole("ADMIN")
							.antMatchers(HttpMethod.DELETE, "/api/admin/**").hasRole("ADMIN")
							
							.antMatchers(HttpMethod.GET, "/api/skykid/**").hasRole("SKYKID")
							.antMatchers(HttpMethod.POST, "/api/skykid/**").hasRole("SKYKID")
							.antMatchers(HttpMethod.PATCH, "/api/skykid/**").hasRole("SKYKID")
							.antMatchers(HttpMethod.PUT, "/api/skykid/**").hasRole("SKYKID")
							.antMatchers(HttpMethod.DELETE, "/api/skykid/**").hasRole("SKYKID")
							
							.anyRequest().authenticated()
						.and()
						.httpBasic();
				// @formatter:on
				return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
