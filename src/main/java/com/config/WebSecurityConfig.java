package com.config;

import org.springframework.context.annotation.Configuration;

/**
 * security配置(在此使用自定义拦截规则)
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter */{
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()//对/和/login路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//设置spring security 的登录页面访问路径为/login
                .defaultSuccessUrl("/index")//登录成功后转向的路径
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //配置两个用户及权限
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("何爽").password("123456").roles("USER")
                .and()
                .withUser("小明").password("123456").roles("USER");
    }

    //静态资源不做拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("resources/static/**");
    }*/
}
