package db.sys.dao;
import db.sys.dto.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersDaoTest {


    @Test
    public void getUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UsersMapper userMapper = (UsersMapper)context.getBean("usersMapper");
        Users user = userMapper.getUserById("1");
        System.out.println(user);


    }
    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UsersMapper userMapper = (UsersMapper)context.getBean("usersMapper");
        Users user = userMapper.getUser("123","123");
        System.out.println(user);


    }
}
