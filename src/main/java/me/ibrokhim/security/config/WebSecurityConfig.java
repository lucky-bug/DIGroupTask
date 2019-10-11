package me.ibrokhim.security.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(@Qualifier(value = "CustomUserDetailsService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/tasks","/tasks/{id}").permitAll()
                .antMatchers("/auth/*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/auth")
                .permitAll()
                .and()
            .logout()
                .permitAll()
        ;
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }
}
