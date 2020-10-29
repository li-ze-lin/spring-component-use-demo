package cn.lzl.mybatis.mapper;

import static cn.lzl.mybatis.mapper.CourseDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lzl.mybatis.model.Course;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface CourseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    BasicColumn[] selectList = BasicColumn.columnList(id, studentId, grade);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source Table: course")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.425+08:00", comments="Source Table: course")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Course> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Course> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CourseResult")
    Optional<Course> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CourseResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default int insert(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(id).toProperty("id")
            .map(studentId).toProperty("studentId")
            .map(grade).toProperty("grade")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default int insertMultiple(Collection<Course> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, course, c ->
            c.map(id).toProperty("id")
            .map(studentId).toProperty("studentId")
            .map(grade).toProperty("grade")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default int insertSelective(Course record) {
        return MyBatis3Utils.insert(this::insert, record, course, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(studentId).toPropertyWhenPresent("studentId", record::getStudentId)
            .map(grade).toPropertyWhenPresent("grade", record::getGrade)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default Optional<Course> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.426+08:00", comments="Source Table: course")
    default List<Course> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    default List<Course> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    default Optional<Course> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, course, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateAllColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(studentId).equalTo(record::getStudentId)
                .set(grade).equalTo(record::getGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Course record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(studentId).equalToWhenPresent(record::getStudentId)
                .set(grade).equalToWhenPresent(record::getGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    default int updateByPrimaryKey(Course record) {
        return update(c ->
            c.set(studentId).equalTo(record::getStudentId)
            .set(grade).equalTo(record::getGrade)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.427+08:00", comments="Source Table: course")
    default int updateByPrimaryKeySelective(Course record) {
        return update(c ->
            c.set(studentId).equalToWhenPresent(record::getStudentId)
            .set(grade).equalToWhenPresent(record::getGrade)
            .where(id, isEqualTo(record::getId))
        );
    }
}