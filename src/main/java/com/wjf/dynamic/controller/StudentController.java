package com.wjf.dynamic.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjf.dynamic.model.Student;
import com.wjf.dynamic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/select")
    public Page<Student> select(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Student> studentList=studentService.queryAllStudent();
//        PageInfo<Student> appsPageInfo = new PageInfo<>(studentList);
        return studentList;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Student student) {
        int id=studentService.insertStudent(student);
        return "插入记录的id :"+id;
    }

    @RequestMapping("/delete")
    public String insert(@RequestParam("sid") String sid) {
        int number= studentService.deleteStudentById(sid);
        return "删除记录数 :"+number;
    }

    @RequestMapping("/upadte")
    public String update(@RequestBody Student student) {
        int number= studentService.updateStudent(student);
        return "修改记录数 :"+number;
    }


}
