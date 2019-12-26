package service.sys.impl;

import db.sys.dao.UsersMapper;
import db.sys.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.sys.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    UsersMapper userMapper;
    @Override
    public Users getUser(String userId, String password) {
        return userMapper.getUser(userId,password);
    }
}

