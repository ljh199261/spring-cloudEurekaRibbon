package com.controller;

import com.entity.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
@Api(value = "学生信息",description = "学生信息")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/selectTeacher")
    @ResponseBody
    @ApiOperation(value = "所有学生信息",notes = "所有学生信息")
    public PageInfo selectTeacher(){
        PageInfo pageInfo = teacherService.selectTeacher();
        return pageInfo;
    }
}
