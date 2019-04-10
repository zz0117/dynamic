package com.wjf.dynamic.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjf.dynamic.model.Love;
import com.wjf.dynamic.model.Student;
import com.wjf.dynamic.model.Teacher;
import com.wjf.dynamic.service.Impl.LoveServiceImpl;
import com.wjf.dynamic.service.LoveService;
import com.wjf.dynamic.service.StudentService;
import com.wjf.dynamic.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    LoveService loveService;

//    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/selectteacher")
    public Page<Teacher> selectteacher(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize")Integer pageSize) {
//        logger.info("hello world");
        PageHelper.startPage(pageNum, pageSize);
        Page<Teacher> teacherList=teacherService.queryAllTeacher();
//        PageInfo<Student> appsPageInfo = new PageInfo<>(studentList);
        return teacherList;
    }

    @RequestMapping("/selectstudent")
    public Page<Student> selectstudent(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize")Integer pageSize) {
//        logger.info("hello world");
        PageHelper.startPage(pageNum, pageSize);
        Page<Student> studentList=studentService.queryAllStudent();
//        PageInfo<Student> appsPageInfo = new PageInfo<>(studentList);
        return studentList;
    }

    @RequestMapping(value = "/insertlove", method = RequestMethod.POST)
    public String insert(@RequestBody Love love) {
        //先查询是否已经存在
        Love love1=loveService.getLoveByOpenId(love.getOpenId());
        if(love1!=null){
        loveService.updateLoveByOpenId(love);
        return "修改记录";
        }else{
            int id=loveService.insertLove(love);
            return "插入记录的id :"+id;
        }
    }

    @RequestMapping("/testtx")
    public String testtx(){
        try {
            Student student = new Student();
//            student.setSid(1);
            student.setSsex("男");
            student.setSagenum(15);
            student.setSname("aa");
            studentService.insertStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "事务回滚 :";
        }
        return "事务没有回滚 ";
    }

    @RequestMapping("/upadte")
    public String update(@RequestBody Student student) {
        int number= studentService.updateStudent(student);
        return "修改记录数 :"+number;
    }


}
