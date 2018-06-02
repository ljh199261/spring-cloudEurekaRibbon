package com.mapper;

import com.entity.Teacher;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("sqlSessionFactory")
public interface TeacherMapper {
    List<Teacher> selectTeacher();
}
