package com.mj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginStatusFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if (uri.contains("/asset/") || uri.contains("/page/")) {
            chain.doFilter(request, response);
        } else if ((uri.contains("/admin") || uri.contains("/save")
        || uri.contains("/remove") || uri.contains("/update") || uri.contains("/edit"))
        && (req.getSession().getAttribute("user") == null)) {
            ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/page/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
