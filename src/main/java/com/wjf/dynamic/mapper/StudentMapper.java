package com.wjf.dynamic.mapper;

import com.github.pagehelper.Page;
import com.wjf.dynamic.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student ")
    @Results({
            @Result(column = "tid",property = "tid"),
            @Result(property="teacher",column="tid",one=@One(select="com.wjf.dynamic.mapper.TeacherMapper.getTeacherById"))
    })
    Page<Student> queryAllStudent();

    @Select("select s.* from student s, teacher t where s.tid = t.tid and t.tid = #{tid}")
    List<Student> findStudents(Integer tid);

    @Insert("insert into student(Sid,Sname,Ssex,Tid,SageNum) values(#{sid},#{sname},#{ssex},#{tid},#{sagenum})")
    @Options(useGeneratedKeys = true,keyProperty = "sid")//加入该注解可以保持对象后，查看对象插入id
    int insertStudent(Student student);

    @Delete("delete from student where Sid=#{sid}")
    int deleteStudentById(String sid);

    @Update("update student set Sname=#{sname},Ssex=#{ssex},Tid=#{tid},SageNum=#{sagenum} where Sid=#{sid}")
    int updateStudent(Student student);
}
