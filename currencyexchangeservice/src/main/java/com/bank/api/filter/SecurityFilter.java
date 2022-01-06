package com.bank.api.filter;

import com.bank.dao.Dao;
import com.bank.dao.impl.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class SecurityFilter implements Filter {

    private UserDaoImpl dao;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        dao = new UserDaoImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String authorization = req.getHeader("Authorization");
        if (authorization == null){
            resp.setStatus(401);
            resp.setHeader("WWW-Authenticate" , "Basic");
        }else{
            int indexSpace = authorization.indexOf(" ");
            String logPassBase64 = authorization.substring(indexSpace + 1);
            System.out.println(logPassBase64);
            String logPass = new String(Base64.getDecoder().decode(logPassBase64));
            String [] parts = logPass.split(":");
            String log = parts[0];
            System.out.println(log);
            String pass = parts[1];
            System.out.println(pass);
            if(dao.validate(log,pass)){
                System.out.println("Вход Выполнен");
                filterChain.doFilter(servletRequest , servletResponse);
            }else {
                resp.setStatus(401);
                resp.setHeader("WWW-Authenticate" , "Basic");
            }
        }

    }
}
