package cn.lzl.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CourseDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source Table: course")
    public static final Course course = new Course();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source field: course.id")
    public static final SqlColumn<Integer> id = course.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source field: course.student_id")
    public static final SqlColumn<Integer> studentId = course.studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source field: course.grade")
    public static final SqlColumn<Integer> grade = course.grade;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source Table: course")
    public static final class Course extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> studentId = column("student_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> grade = column("grade", JDBCType.INTEGER);

        public Course() {
            super("course");
        }
    }
}