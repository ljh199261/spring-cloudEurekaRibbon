package com.service;

import com.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
public interface UserService {
    PageInfo selectUser();
}
