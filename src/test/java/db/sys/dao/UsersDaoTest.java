package db.sys.dao;
import db.sys.dto.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersDaoTest {


    @Test
    public void getUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        usersMapper userMapper = (usersMapper)context.getBean("usersMapper");
        Users user = userMapper.getUserById("1");
        System.out.println(user);


    }
}
