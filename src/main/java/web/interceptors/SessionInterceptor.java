package web.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 测试输出
        System.out.println("SessionInterceptor.preHandle()");

        // 拦截规则：
        // 如果未登录，重定向到登录，并拦截
        // 如果已登录，直接放行
        HttpSession session = request.getSession();
        if (session.getAttribute("userinfo") == null) {
            response.sendRedirect(request.getContextPath()+"/modules/system/login.jsp");
            return false;
        }

        // 返回：true=放行，false=拦截
        return true;
    }
}
