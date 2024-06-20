package com.example.elibrary.security;

import com.example.elibrary.service.UserDetailsServiceImpl;
import io.jsonwebtoken.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select userid, password, 'true' from user where userid=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select u.userid, r.roles_type as role from user u join lt_user_roles r on u.roles = r.roles_id where u.userid = ?");
//        return jdbcUserDetailsManager;
//
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req.requestMatchers("/login/**", "/register/**", "/resources/**", "/public/**", "/")
                                .permitAll()
                                .requestMatchers("/patron/**").hasAuthority("PATRON")
                                .requestMatchers("/librarian/**").hasAuthority("LIBRARIAN")
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .anyRequest()
                                .authenticated()
                ).userDetailsService(userDetailsServiceImpl)
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
