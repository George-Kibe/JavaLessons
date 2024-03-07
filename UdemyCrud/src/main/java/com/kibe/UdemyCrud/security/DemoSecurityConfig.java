package com.kibe.UdemyCrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
    // Add support for JDBC instead of hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve  a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        // define aa query to retrieve roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }

    // Restrict URL access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/rest/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/rest/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/rest/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/rest/members/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/rest/members/**").hasRole("ADMIN")
                        .anyRequest().permitAll()  // Allows access to any other request
                );
        // use HTTP Basic authentication that uses username and password
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF) that is not required for REST APIs that use POST, PUT, DELETE and PATCH
        // http.csrf(csrf -> csrf.disable());
        http.csrf(AbstractHttpConfigurer::disable);

        return  http.build();
    }
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("John")
                .password("{noop}test1234")
                .roles("EMPLOYEE")
                .build();
        UserDetails george = User.builder()
                .username("George")
                .password("{noop}test1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails kibe = User.builder()
                .username("Kibe")
                .password("{noop}test1234")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, george, kibe);
    }
     */
}
