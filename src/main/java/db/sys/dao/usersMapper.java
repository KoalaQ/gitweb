package db.sys.dao;

import db.sys.dto.Users;
import org.apache.ibatis.annotations.Param;

public interface usersMapper {
    Users getUserById(@Param("urid")String urid);
}
