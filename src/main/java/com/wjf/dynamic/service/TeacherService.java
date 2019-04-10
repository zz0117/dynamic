package com.wjf.dynamic.service;

import com.github.pagehelper.Page;
import com.wjf.dynamic.model.Teacher;


public interface TeacherService {
    Page<Teacher> queryAllTeacher();

    Teacher getTeacherById(int tid);

    int insertTeacher(Teacher teacher);

    int deleteTeacherById(String tid);

    int updateTeacher(Teacher teacher);


}
