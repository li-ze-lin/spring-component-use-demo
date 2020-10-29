package cn.lzl.mybatis.model;

import javax.annotation.Generated;

public class Course {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.student_id")
    private Integer studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.grade")
    private Integer grade;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.student_id")
    public Integer getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.424+08:00", comments="Source field: course.student_id")
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source field: course.grade")
    public Integer getGrade() {
        return grade;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source field: course.grade")
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}