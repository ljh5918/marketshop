package com.marketshop.marketshop.config;

import com.marketshop.marketshop.config.auth.PrincipalOauth2UserService;
import com.marketshop.marketshop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Form Login 설정
        http.formLogin(formLogin -> formLogin
                .loginPage("/members/login")               // 로그인 페이지 URL
                .defaultSuccessUrl("/")                    // 로그인 성공 시 이동할 URL
                .usernameParameter("email")                // 로그인 시 사용할 파라미터 이름
                .failureUrl("/members/login/error")        // 로그인 실패 시 이동할 URL
        );

        // 로그아웃 설정
        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) // 로그아웃 URL
                .logoutSuccessUrl("/")                     // 로그아웃 성공 시 이동할 URL
        );

        // OAuth2 로그인 설정
        http.oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/")                    // OAuth2 로그인 성공 시 이동할 URL
                .userInfoEndpoint(userInfo -> userInfo
                        .userService(principalOauth2UserService)  // 사용자 정보 서비스 설정
                )
        );

        // 권한 설정
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll() // 모든 사용자가 인증 없이 접근 가능
                .requestMatchers("/", "/members/**", "/item/**", "/images/**", "/mail/**", "/search/**").permitAll()
                .requestMatchers("/admin/**").hasRole("USER")               // /admin/** 경로는 ADMIN 권한 필요
                .anyRequest().authenticated()                                // 그 외의 모든 요청은 인증 필요
        );

        // CSRF 설정
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/mail/**", "/members/findId")
        );

        // 예외 처리 설정
        http.exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 인증되지 않은 사용자 처리
        );

        // 세션 관리 설정
        http.sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)          // 항상 세션 생성
        );

        return http.build();
    }


    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**");
    }


}
