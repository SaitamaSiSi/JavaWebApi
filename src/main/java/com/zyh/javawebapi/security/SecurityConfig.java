package com.zyh.javawebapi.security;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 功能
 * 作者：Zyh
 * 日期：2025年02月14日
 */
@Configuration
@EnableWebSecurity        // 该注解启用 Spring Security 的 web 安全功能。
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 创建基于内存的用户信息管理器
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();


        manager.createUser(
                // 创建UserDetails对象，用于管理用户名、用户密码、用户角色、用户权限等内容
                User.withDefaultPasswordEncoder().username("user").password("user123").roles("USER").build()
        );
        // 如果自己配置的有账号密码, 那么上面讲的 user 和 随机字符串 的默认密码就不能用了
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HttpSession httpSession) throws Exception {
//        http
//                // 开启授权保护
//                .authorizeHttpRequests(authorize -> authorize
//                        // 不需要认证的地址有哪些
//                        .requestMatchers("/blog/**", "/public/**", "/about").permitAll()	// ** 通配符
//                        // 对所有请求开启授权保护
//                        .anyRequest().
//                        // 已认证的请求会被自动授权
//                                authenticated()
//                )
//                // 使用默认的登陆登出页面进行授权登陆
//                .formLogin(Customizer.withDefaults())
//                // 启用“记住我”功能的。允许用户在关闭浏览器后，仍然保持登录状态，直到他们主动注销或超出设定的过期时间。
//                .rememberMe(Customizer.withDefaults());
        // 关闭 csrf CSRF（跨站请求伪造）是一种网络攻击，攻击者通过欺骗已登录用户，诱使他们在不知情的情况下向受信任的网站发送请求。
        http.csrf(c -> c.disable()); // 禁用CSRF防护
        http.httpBasic(h -> h.disable()); // 禁用基本认证
        http.formLogin( f -> f.disable()); // 禁用表单登录
        http.sessionManagement(s ->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // 禁用会话管理

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        // configure Web security...
//    }

}
