package web.controller;

import web.beans.ComResult;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import db.sys.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.sys.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/hello")
    public void hello(HttpServletResponse resp){
        try {
            resp.getWriter().println("123132132");
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fangwendao ");
    }
    @RequestMapping("/login")
    public void login(HttpServletRequest req,HttpServletResponse resp){
        ComResult comResult=new ComResult();
        comResult.setRetcode(ComResult.RETCODEOK);
        HttpSession session = req.getSession();
        if(session.getAttribute("userinfo") != null){
            session.setAttribute("userinfo",null);
        }
        try {
            String userId = req.getParameter("userid");
            String password = req.getParameter("password");
            if(StrUtil.isBlank(userId)){
                throw new Exception("用户名为空！");
            }
            if(StrUtil.isBlank(password)){
                throw new Exception("密码为空！");
            }
            Users user=loginService.getUser(userId,password);
            if(user!=null){
                req.getSession().setAttribute("userinfo",user);
                comResult.setRetstatus(ComResult.STATUSOK);
            }else{
                comResult.setRetstatus(ComResult.STATUSFAIL);
                comResult.setRetdata("用户名或密码错误！");
            }
        } catch (Exception e) {
            comResult.setRetstatus(ComResult.STATUSFAIL);
            comResult.setRetdata(e.getMessage());
            e.printStackTrace();
        }
        String msg=JSON.toJSONString(comResult);
        try {
            resp.setHeader("content-type","text/html;charset=utf-8");
            //resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(msg);
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
