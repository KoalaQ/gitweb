package db.sys.dao;

import db.sys.dto.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    Users getUserById(@Param("urid")String urid);
    Users getUser(@Param("id")String id,@Param("password")String password);
}
