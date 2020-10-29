package cn.lzl.mybatis.model;

import javax.annotation.Generated;

public class Student {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.398+08:00", comments="Source field: student.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.age")
    private Integer age;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.402+08:00", comments="Source field: student.no")
    private String no;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.401+08:00", comments="Source field: student.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.402+08:00", comments="Source field: student.age")
    public Integer getAge() {
        return age;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.402+08:00", comments="Source field: student.age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.402+08:00", comments="Source field: student.no")
    public String getNo() {
        return no;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.402+08:00", comments="Source field: student.no")
    public void setNo(String no) {
        this.no = no;
    }
}