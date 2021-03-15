package com.example.lufthavn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public DataSource dataSource(){
            return DataSourceBuilder
                    .create()
                    .url("jdbc:mysql://54.234.57.19:3306/cph_airport?serverTimezone=UTC")
                    .username("root")
                    .password("22422606")
                    .build();
    }
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/arrdeplist").hasAnyAuthority("ROLE_ADMIN","ROLE_FLYVELEDER")
                .antMatchers("/airports").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/standpladslist").hasAnyAuthority("ROLE_ADMIN", "ROLE_FLYVELEDER")
                .antMatchers("/statuslistmedium").hasAnyAuthority("ROLE_ADMIN", "ROLE_FLYVELEDER", "ROLE_EMPLOYEE")
                .and()
                .formLogin();
        http.csrf().disable();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
