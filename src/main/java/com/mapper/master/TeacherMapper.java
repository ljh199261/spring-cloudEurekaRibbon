package com.mapper.master;

import com.entity.Teacher;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("masterSqlSessionFactory")
public interface TeacherMapper {
    List<Teacher> selectTeacher();
}
