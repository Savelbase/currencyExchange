package com.bank.handler;

import com.bank.dto.ErrorResponse;
import com.bank.mapper.BaseMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DispatcherServlet extends HttpServlet {

    private final Map<String, RestHandler<HttpServletRequest, ?>> handlers = new ConcurrentHashMap<>();
    private final BaseMapper baseMapper = new BaseMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("DispatcherServlet : init()");
        super.init(config);
        handlers.put("/api/v1/login", new LoginHandler());
        handlers.put("/api/v1/signin", new SignInHandler());
        handlers.put("/api/v1/transaction", new TransactionHandler());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI().replaceFirst("^" + req.getContextPath(), "").trim();
        System.out.println("requestURI: " + requestURI);
        RestHandler<HttpServletRequest, ?> handler = handlers.get(requestURI);
        System.out.println("handler = " + handler.toString());
        switch (req.getMethod()) {
            case "POST":
                resp.setContentType("application/json");
                try {
                    Object dto = handler.post(req);
                    resp.setStatus(201);
                    resp.getWriter().write(baseMapper.toJson(dto));
                } catch (Throwable ex) {
                    ex.printStackTrace();
                    resp.setStatus(500);
                    resp.getWriter().write(baseMapper.toJson(new ErrorResponse(1, ex.getMessage())));
                }
                break;
            case "GET":
                resp.setContentType("application/json");
                try {
                    Object user = handler.get(req);
                    resp.setStatus(201);
                    resp.getWriter().write(baseMapper.toJson(user));
                } catch (Throwable ex) {
                    ex.printStackTrace();
                    resp.setStatus(500);
                    resp.getWriter().write(baseMapper.toJson(new ErrorResponse(1, ex.getMessage())));
                }
                break;
            case "PUT":
                handler.put(req);
                break;
            case "DELETE":
                handler.delete(req);
                break;
            default:
                break;
        }
    }
}
