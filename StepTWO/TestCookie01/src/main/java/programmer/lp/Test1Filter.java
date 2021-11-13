package programmer.lp;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class Test1Filter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 对客户端的请求进行处理
        System.out.println("Test1Filter - doFilter - start");

        // 放行客户端的请求
        chain.doFilter(request, response);

        // 对服务器的响应进行处理
        System.out.println("Test1Filter - doFilter - end");
    }

    @Override
    public void destroy() {
    }

}
