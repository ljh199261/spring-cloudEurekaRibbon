package com.controller;

import java.util.List;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户信息",description = "用户信息")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/selectUser")
    @ResponseBody
    @ApiOperation(value ="查询所有用户信息" ,notes = "查询所有用户信息")
    public PageInfo selectUser(){
        PageInfo pageInfo = userService.selectUser();
        return pageInfo;
    }
}
