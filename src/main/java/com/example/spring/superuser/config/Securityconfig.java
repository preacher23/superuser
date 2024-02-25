//package com.example.spring.superuser.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableMethodSecurity
//public class Securityconfig {
//
//    private UserDetailsService userDetailsService;
//
//  public Securityconfig(UserDetailsService userDetailsService){
//      this.userDetailsService=userDetailsService;//database authenication
//  }
//
//
//   @Bean
//  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//      return authenticationConfiguration.getAuthenticationManager();
//  }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf((csrf)->csrf.disable()).authorizeHttpRequests((authorize)->
//                //authorize.anyRequest().authenticated()
//                authorize.requestMatchers(HttpMethod.GET,"/getall/**").permitAll().
//                requestMatchers(HttpMeyhod.Post,"/login/**").anyRequest().authenticated()
//        ).httpBasic(Customizer.withDefaults());
//       return httpSecurity.build();
//    }
//   @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails gokul= User.builder().username("gokul")
//                .password(passwordEncoder().encode("password")).roles("USER").build();
//
//        UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(gokul,admin);
//    }
//}
