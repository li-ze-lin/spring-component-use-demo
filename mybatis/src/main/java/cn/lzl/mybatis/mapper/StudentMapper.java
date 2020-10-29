package cn.lzl.mybatis.mapper;

import static cn.lzl.mybatis.mapper.StudentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lzl.mybatis.model.Student;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
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
public interface StudentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.417+08:00", comments="Source Table: student")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, age, no);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.407+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.408+08:00", comments="Source Table: student")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.408+08:00", comments="Source Table: student")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Student> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.411+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StudentResult")
    Optional<Student> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.412+08:00", comments="Source Table: student")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StudentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="no", property="no", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.412+08:00", comments="Source Table: student")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.413+08:00", comments="Source Table: student")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.413+08:00", comments="Source Table: student")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.414+08:00", comments="Source Table: student")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.414+08:00", comments="Source Table: student")
    default int insert(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(name).toProperty("name")
            .map(age).toProperty("age")
            .map(no).toProperty("no")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.416+08:00", comments="Source Table: student")
    default int insertSelective(Student record) {
        return MyBatis3Utils.insert(this::insert, record, student, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
            .map(age).toPropertyWhenPresent("age", record::getAge)
            .map(no).toPropertyWhenPresent("no", record::getNo)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.418+08:00", comments="Source Table: student")
    default Optional<Student> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.418+08:00", comments="Source Table: student")
    default List<Student> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.419+08:00", comments="Source Table: student")
    default List<Student> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.419+08:00", comments="Source Table: student")
    default Optional<Student> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.42+08:00", comments="Source Table: student")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, student, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.42+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateAllColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName)
                .set(age).equalTo(record::getAge)
                .set(no).equalTo(record::getNo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.42+08:00", comments="Source Table: student")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Student record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName)
                .set(age).equalToWhenPresent(record::getAge)
                .set(no).equalToWhenPresent(record::getNo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.421+08:00", comments="Source Table: student")
    default int updateByPrimaryKey(Student record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(age).equalTo(record::getAge)
            .set(no).equalTo(record::getNo)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-10-16T09:52:27.422+08:00", comments="Source Table: student")
    default int updateByPrimaryKeySelective(Student record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(age).equalToWhenPresent(record::getAge)
            .set(no).equalToWhenPresent(record::getNo)
            .where(id, isEqualTo(record::getId))
        );
    }
}