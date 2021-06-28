package spring06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//BCryptPasswordEncoder : 복호화가 불가능한 암호화 방법을 제공하는 인코더
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // url별 권한 관리를 설정하는 옵션
		
			.antMatchers("/" ,"/member/**","/log/**")
			.permitAll(); //모든 권한
		
		http.csrf().disable();
	}

	
}
