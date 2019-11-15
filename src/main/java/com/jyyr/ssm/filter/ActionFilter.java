package com.jyyr.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActionFilter implements Filter {
    private List<String> accessibleEnter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化方法");
            accessibleEnter = new ArrayList<>();
            accessibleEnter.add("main.do");
            accessibleEnter.add("regNow.do");
            accessibleEnter.add("login.do");
            accessibleEnter.add("regInfo.do");
            accessibleEnter.add("logManager.do");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ActionFilter.doFilter()");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        System.out.println(" ================过滤器路径 uri "+ uri);
        String[] pathArray = uri.split("/");
        String file = pathArray[pathArray.length-1];
        System.out.println("====访问路径==== " + file);
        if(accessibleEnter.contains(file)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else{
            //判断是否登录
            HttpSession session = request.getSession();
            if(session.getAttribute("uid") != null){
                //已登录放行
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else if(session.getAttribute("manager") != null){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }else{
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                String loginUri = request.getContextPath() + "/main.do";
//                System.out.println("===从定向到== = " +loginUri);
                response.sendRedirect(loginUri);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
