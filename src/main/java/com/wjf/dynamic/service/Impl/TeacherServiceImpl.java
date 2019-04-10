package com.wjf.dynamic.service.Impl;

import com.github.pagehelper.Page;
import com.wjf.dynamic.mapper.TeacherMapper;
import com.wjf.dynamic.model.Teacher;
import com.wjf.dynamic.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> queryAllTeacher() {
        return teacherMapper.queryAllTeacher();
    }

    @Override
    public Teacher getTeacherById(int tid) {
        return teacherMapper.getTeacherById(tid);
    }

    @Override
    @Transactional
    public int insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
        return teacher.getTid();
    }

    @Override
    @Transactional
    public int deleteTeacherById(String tid) {
        return teacherMapper.deleteTeacherById(tid);
    }

    @Override
    @Transactional
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }


}
