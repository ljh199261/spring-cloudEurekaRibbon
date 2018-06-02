package com.mapper;

import com.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("sqlSessionFactory")
public interface UserMapper {
    List<User> selectUser();
}
