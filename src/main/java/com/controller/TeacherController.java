package com.controller;

import com.base.BaseController;
import com.base.ResultResponse;
import com.github.pagehelper.PageInfo;
import com.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/teacher", produces = "application/json;charset=utf-8")
@Api(value = "测试学生信息",description = "测试学生信息")
public class TeacherController extends BaseController{


    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/selectTeacher")
    @ResponseBody
    @ApiOperation(value = "所有学生信息",notes = "所有学生信息")
    public ResultResponse selectTeacher(){
        PageInfo pageInfo = teacherService.selectTeacher();

        return getResultResponse("200", pageInfo);
    }
}
