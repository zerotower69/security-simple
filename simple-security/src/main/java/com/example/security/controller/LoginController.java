package com.example.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeroTower
 * @Date 2021/1/23 14:28
 * @Description
 * @Package com.example.security.controller
 * @PROJECT security-simple
 **/
@Controller
@Slf4j
public class LoginController {

    private Logger logger=LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String showName(){
        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录用户: {}",name);
        return "home.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }

    /**
     * 登录失败
     * @param request
     * @param response
     */
    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response){
       response.setContentType("text/html; charset=UTF-8");
        AuthenticationException exception=
                (AuthenticationException)   request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try{
             response.getWriter().write(exception.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('admin')")
    public String printAdmin(){
        return "看到这里,说明当前用户是管理员";
    }

    @RequestMapping("/teacher")
    @ResponseBody
    @PreAuthorize("hasAuthority('teacher')")
    public String printUser(){
        return "看到这里，当前用户是教师";
    }

    @RequestMapping("/admin/crud")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','c')")
    public String printAdminC(){
        return "看到这里，说明你访问/admin具有c权限";
    }

}
