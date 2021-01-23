package com.example.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 15:37
 * @Description
 * @Package com.example.security.security
 * @PROJECT security-simple
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //注入用户自定义的服务
    @Autowired
    private CustomUserDetailService customUserDetailService;

    //密码构造Bean
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入自定义的PermissionEvaluator
     * @return
     */
    @Bean
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler(){
        DefaultWebSecurityExpressionHandler handler=new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new CustomPermissionEvaluator());
        return handler;
    }

    /**
     * 权限认证构造器配置
     * 密码使用
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailService)
                //这是使用明文密码的方案
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        return s.equals(charSequence);
                    }
                });
    }

    /**
     * 自定义的请求配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 如果有允许匿名的url，填在下面
                //登录生成验证码
                .antMatchers("/getVerifyCode").permitAll()
                //.antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
                //设置自定义的登录页
                .formLogin().loginPage("/login")
                //自定义的登录成功页面
                .defaultSuccessUrl("/",false).permitAll()
                //自定义登录失跳转
                .failureUrl("/login/error")
                //登出
                .and()
                .logout().permitAll()
                .and()
                //记住我，自动登录
                .rememberMe()
                .and()
                //关闭csrf跨域攻击防护
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置拦截忽略选项，放行静态文件
        web.ignoring().antMatchers("/css/**","/js/**");
    }
}
