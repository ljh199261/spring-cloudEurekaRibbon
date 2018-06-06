package com.mapper.master;

import com.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("masterSqlSessionFactory")
public interface UserMapper {
    List<User> selectUser();
}
