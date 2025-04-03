package com.example.EC3.Config;

import com.example.EC3.Model.User;
import com.example.EC3.Service.UserDetailsImplement;
import com.example.EC3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsImplement userDetailsImplement;

    @Autowired
    private UserService userService;

    //Configuramos el Encriptador/Desencriptador
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    //Configuramos el uso de nuestras propias tablas
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder());
        auth.setUserDetailsService(userDetailsImplement);

        return auth;
    }

    @Bean
    //Decirle a spring boot que use nuestro provider de modo global
    public AuthenticationManager authorizationManager(HttpSecurity http) throws Exception {
        return http.
                getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequest -> authorizeRequest
                        .requestMatchers("/css/**", "/login").permitAll()
                        .requestMatchers("/Estudiantes").hasAuthority("ADMIN")
                        .requestMatchers("/Matriculas", "/Cursos").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/Usuarios", "/Profesores").hasAuthority("ADMIN")
                        .anyRequest().authenticated()  // Resto de rutas requieren autenticación
                )
                .formLogin(formLogin -> formLogin
                        .permitAll()
                        .defaultSuccessUrl("/home", true)  // Redirige a /home después de un login exitoso
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()  // Permite acceso al logout
                );

        return http.build();
    }

//    @Bean
//    public CommandLineRunner createAdmin(){
//        return args -> {
//            User userAdmin = new User("ADMIN", "1234", "ADMIN", true);
//            userService.registrar(userAdmin);
//        };
//    }


}


