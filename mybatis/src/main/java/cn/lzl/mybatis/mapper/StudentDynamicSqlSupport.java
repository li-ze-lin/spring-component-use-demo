package cn.lzl.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class StudentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.406+08:00", comments="Source Table: student")
    public static final Student student = new Student();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.406+08:00", comments="Source field: student.id")
    public static final SqlColumn<Integer> id = student.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.406+08:00", comments="Source field: student.name")
    public static final SqlColumn<String> name = student.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.407+08:00", comments="Source field: student.age")
    public static final SqlColumn<Integer> age = student.age;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.407+08:00", comments="Source field: student.no")
    public static final SqlColumn<String> no = student.no;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.406+08:00", comments="Source Table: student")
    public static final class Student extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public final SqlColumn<String> no = column("no", JDBCType.VARCHAR);

        public Student() {
            super("student");
        }
    }
}