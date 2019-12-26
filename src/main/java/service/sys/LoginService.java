package service.sys;

import db.sys.dto.Users;

public interface LoginService {
    Users getUser(String userId,String password);
}
