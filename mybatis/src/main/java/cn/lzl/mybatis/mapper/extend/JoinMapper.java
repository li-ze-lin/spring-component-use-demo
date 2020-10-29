package cn.lzl.mybatis.mapper.extend;

import cn.lzl.mybatis.model.extend.Join;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

import static cn.lzl.mybatis.mapper.CourseDynamicSqlSupport.course;
import static cn.lzl.mybatis.mapper.StudentDynamicSqlSupport.student;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;

@Mapper
public interface JoinMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    List<Join> select(SelectStatementProvider selectStatement);

    default List<Join> selectAll() {
        SelectStatementProvider render = SqlBuilder.select(student.id, student.name, student.age, student.no, course.id.as("courseId"), course.grade)
                .from(student, "s")
                .join(course, "c").on(student.id, equalTo(course.studentId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return select(render);
    }
}
