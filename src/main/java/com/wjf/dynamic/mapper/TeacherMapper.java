package com.wjf.dynamic.mapper;

import com.github.pagehelper.Page;
import com.wjf.dynamic.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher ")
    @Results({
            @Result(column = "tid",property = "tid"),
            @Result(property = "studentList",javaType = List.class,column = "tid",//column = "id":表示拿着category表中的主键id，去查询product表
                    many = @Many(select = "com.wjf.dynamic.mapper.StudentMapper.findStudents"))
    })
    Page<Teacher> queryAllTeacher();

    @Select("select * from teacher where tid=#{tid}")
    Teacher getTeacherById(int tid);

    @Insert("insert into teacher(Tid,Tname,username,password) values(#{tid},#{tname},#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "tid")//加入该注解可以保持对象后，查看对象插入id
    int insertTeacher(Teacher teacher);

    @Delete("delete from teacher where Tid=#{tid}")
    int deleteTeacherById(String sid);

    @Update("update teacher set Tname=#{tname},username=#{username},password=#{password} where Tid=#{tid}")
    int updateTeacher(Teacher teacher);
}
