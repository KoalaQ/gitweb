package web.interceptors;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        String page = requestURI.substring(request.getContextPath().length());
        // 测试输出
        System.out.println("SessionFilter.doFilter()");
        if(!page.endsWith("system/login.jsp") && !page.endsWith("user/login/login.do") ){
            // 拦截规则：
            // 如果未登录，重定向到登录，并拦截
            // 如果已登录，直接放行
            HttpSession session = request.getSession();
            if (session.getAttribute("userinfo") == null) {
                response.sendRedirect(request.getContextPath()+"/modules/system/login.jsp");
                return;
            }
        }
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
