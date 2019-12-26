package sys.impl;

import db.sys.dto.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.sys.LoginService;


public class LoginServiceImplTest {

    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        LoginService loginService = (LoginService)context.getBean("loginService");
        Users user = loginService.getUser("123","123");
        System.out.println(user);
    }
}
