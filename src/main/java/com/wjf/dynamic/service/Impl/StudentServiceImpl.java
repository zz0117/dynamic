package com.wjf.dynamic.service.Impl;

import com.github.pagehelper.Page;
import com.wjf.dynamic.mapper.StudentMapper;
import com.wjf.dynamic.model.Student;
import com.wjf.dynamic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Page<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    @Override
    @Transactional
    public int insertStudent(Student student) {
        studentMapper.insertStudent(student);
        return student.getSid();
    }

    @Override
    @Transactional
    public int deleteStudentById(String sid) {
        return studentMapper.deleteStudentById(sid);
    }

    @Override
    @Transactional
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }


}
