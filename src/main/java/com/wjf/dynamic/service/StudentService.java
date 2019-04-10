package com.wjf.dynamic.service;

import com.github.pagehelper.Page;
import com.wjf.dynamic.model.Student;


public interface StudentService {
    Page<Student> queryAllStudent();

    int insertStudent(Student student);

    int deleteStudentById(String sid);

    int updateStudent(Student student);


}
