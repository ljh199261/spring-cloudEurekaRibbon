package com.service.impl;
import java.util.List;
import com.entity.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.TeacherMapper;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo selectTeacher() {
        Integer pageNum = 1;
        Integer pageSize = 20;
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers = teacherMapper.selectTeacher();
        PageInfo pageInfo = new PageInfo(teachers);
        return pageInfo;
    }
}
