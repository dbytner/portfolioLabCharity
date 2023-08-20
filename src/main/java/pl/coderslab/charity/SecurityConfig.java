package pl.coderslab.charity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User
//                .withUsername("user@user.pl")
//                .password("$2a$12$mRJUNZaKkl6LGJGGrPjkI.6rb.27aliQmVGsoHcZQ41VIpWJHrA9.")
//                .roles("USER")
//                .build();
//        UserDetails admin = User
//                .withUsername("admin")
//                .password("$2a$12$mRJUNZaKkl6LGJGGrPjkI.6rb.27aliQmVGsoHcZQ41VIpWJHrA9.")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/donations/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/", "/register").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/donation");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
