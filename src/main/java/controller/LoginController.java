package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/login")
public class LoginController {

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
}
