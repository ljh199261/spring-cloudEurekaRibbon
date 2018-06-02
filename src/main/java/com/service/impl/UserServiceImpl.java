package com.service.impl;
import java.util.List;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.master.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo selectUser() {
        Integer pageNum = 1;
        Integer pageSize = 20;
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectUser();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }
}
