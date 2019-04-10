package com.wjf.dynamic.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjf.dynamic.model.Student;
import com.wjf.dynamic.model.Teacher;
import com.wjf.dynamic.service.StudentService;
import com.wjf.dynamic.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/select")
    public Page<Teacher> select(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Teacher> teachertList=teacherService.queryAllTeacher();
//        PageInfo<Student> appsPageInfo = new PageInfo<>(studentList);
        return teachertList;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody Teacher teacher) {
        int id=teacherService.insertTeacher(teacher);
        return "插入记录的id :"+id;
    }

    @RequestMapping("/delete")
    public String insert(@RequestParam("tid") String tid) {
        int number= teacherService.deleteTeacherById(tid);
        return "删除记录数 :"+number;
    }

    @RequestMapping("/upadte")
    public String update(@RequestBody Teacher teacher) {
        int number= teacherService.updateTeacher(teacher);
        return "修改记录数 :"+number;
    }


}
