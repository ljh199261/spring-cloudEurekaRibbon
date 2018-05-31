package com.service;

import com.EurekaRibbonApplication;
import com.entity.Teacher;
import com.github.pagehelper.PageInfo;
import com.mapper.TeacherMapper;
import com.service.impl.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=EurekaRibbonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@EnableAutoConfiguration
public class TeacherServiceTest {

    //实际调用的方法
    @InjectMocks
    private TeacherService teacherService = new TeacherServiceImpl();
    //虚拟的方法
    @Mock
    private TeacherMapper teacherMapper;

    private List<Teacher> teacherList;


    @Before
    public void initData(){
        teacherList  = new ArrayList<>();
    }

    @Test
    public void selectTeacherTest(){
        when(teacherMapper.selectTeacher()).thenReturn(teacherList);
        PageInfo pageInfo = teacherService.selectTeacher();
        System.out.println(pageInfo);
    }

}
