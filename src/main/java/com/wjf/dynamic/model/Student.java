package com.wjf.dynamic.model;

public class Student {
    private Integer sid;

    private String sname;

    private String ssex;

    private Integer tid;

    private Integer sagenum;

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSagenum() {
        return sagenum;
    }

    public void setSagenum(Integer sagenum) {
        this.sagenum = sagenum;
    }
}