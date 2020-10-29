# spring boot mybatis 使用演示
- 使用mybatis dynamic sql 去除xml
- 使用generator maven插件自动生成实体和mapper
- 使用mysql做演示

## pom引入
```xml
<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.3</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis.dynamic-sql</groupId>
            <artifactId>mybatis-dynamic-sql</artifactId>
            <version>1.2.1</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>
</dependencies>
<build>
    <plugins>
        <!--自动生成插件-->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.4.0</version>
            <configuration>
                <configurationFile>generator.xml</configurationFile>
                <verbose>true</verbose>
                <overwrite>true</overwrite>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## 使用
- [自动生成 StudentMapper](https://github.com/li-ze-lin/spring-component-use-demo/blob/mybatis/src/main/java/cn/lzl/mybatis/mapper/StudentMapper.java)
- [自建用于演示join JoinMapper](https://github.com/li-ze-lin/spring-component-use-demo/blob/mybatis/src/main/java/cn/lzl/mybatis/mapper/extend/JoinMapper.java)
- [example](https://github.com/li-ze-lin/spring-component-use-demo/blob/mybatis/src/test/java/cn/lzl/mybatis/mapper/StudentMapperTest.java)
```java
class StudentMapperTest extends MybatisApplicationTests {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private JoinMapper joinMapper;

    @Test
    void testCount() {
        /*
         * 2020-10-15 18:24:50.310 DEBUG 16396 --- [           main] c.l.mybatis.mapper.StudentMapper.count   : ==>  Preparing: select count(*) from student where id = ?
         * 2020-10-15 18:24:50.341 DEBUG 16396 --- [           main] c.l.mybatis.mapper.StudentMapper.count   : ==> Parameters: 7(Integer)
         * 2020-10-15 18:24:50.370 DEBUG 16396 --- [           main] c.l.mybatis.mapper.StudentMapper.count   : <==      Total: 1
         * 1
         */
        long count = studentMapper.count(c -> c.where().and(id, isEqualTo(7)));
        System.out.println(count);
    }

    @Test
    void testDelete() {
        /*
         * 2020-10-15 18:26:45.041 DEBUG 7328 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : ==>  Preparing: delete from student where id = ?
         * 2020-10-15 18:26:45.081 DEBUG 7328 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : ==> Parameters: 8(Integer)
         * 2020-10-15 18:26:45.095 DEBUG 7328 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : <==    Updates: 1
         * 1
         */
        int delete = studentMapper.delete(c -> c.where(id, isEqualTo(8)));
        System.out.println(delete);
    }

    @Test
    void deleteByPrimaryKey() {
        /*
         * 2020-10-15 18:25:44.194 DEBUG 16472 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : ==>  Preparing: delete from student where id = ?
         * 2020-10-15 18:25:44.240 DEBUG 16472 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : ==> Parameters: 7(Integer)
         * 2020-10-15 18:25:44.254 DEBUG 16472 --- [           main] c.l.mybatis.mapper.StudentMapper.delete  : <==    Updates: 1
         * 1
         */
        int i = studentMapper.deleteByPrimaryKey(7);
        System.out.println(i);
    }

    @Test
    void testInsert() {
        /*
         * 2020-10-15 16:09:23.956 DEBUG 7624 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : ==>  Preparing: insert into student (id, name, age, no) values (?, ?, ?, ?)
         * 2020-10-15 16:09:24.005 DEBUG 7624 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : ==> Parameters: null, 19b064ca-d15a-4503-9a5e-1b3ebb7b62eb(String), 10(Integer), 13c31fe3-33df-46fe-865d-6652ad3113fa(String)
         * 2020-10-15 16:09:24.018 DEBUG 7624 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : <==    Updates: 1
         */
        studentMapper.insert(getNewStudent());
    }

    @Test
    void testInsertMultiple() {
        /*
         * 2020-10-15 16:09:57.493 DEBUG 18008 --- [           main] c.l.m.m.StudentMapper.insertMultiple     : ==>  Preparing: insert into student (id, name, age, no) values (?, ?, ?, ?), (?, ?, ?, ?)
         * 2020-10-15 16:09:57.546 DEBUG 18008 --- [           main] c.l.m.m.StudentMapper.insertMultiple     : ==> Parameters: null, 353cfc5f-dc71-48cf-8051-0c2054f9e6cd(String), 17(Integer), 63d4c873-cf3d-488b-b9f9-e941bfc389ed(String), null, 799704db-b665-40c1-98d3-11bba095de63(String), 75(Integer), f52873b4-1b91-476f-99e2-c5c70395f9cf(String)
         * 2020-10-15 16:09:57.559 DEBUG 18008 --- [           main] c.l.m.m.StudentMapper.insertMultiple     : <==    Updates: 2
         */
        //需要返回ID的 自动生成将不提供该方法
        //studentMapper.insertMultiple(Arrays.asList(getNewStudent(), getNewStudent()));
    }

    @Test
    void insertSelective() {
        /*
         * 2020-10-15 16:10:28.337 DEBUG 10928 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : ==>  Preparing: insert into student (name, age, no) values (?, ?, ?)
         * 2020-10-15 16:10:28.375 DEBUG 10928 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : ==> Parameters: 3ce681a6-f9d4-4373-9671-83dd829fac31(String), 63(Integer), 91ae1380-df01-4870-9d39-0de128d03629(String)
         * 2020-10-15 16:10:28.389 DEBUG 10928 --- [           main] c.l.mybatis.mapper.StudentMapper.insert  : <==    Updates: 1
         */
        studentMapper.insertSelective(getNewStudent());
    }

    @Test
    void testSelectOne() {
        /*
         * 2020-10-15 16:12:09.812 DEBUG 8484 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : ==>  Preparing: select id, name, age, no from student where id = ?
         * 2020-10-15 16:12:09.847 DEBUG 8484 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : ==> Parameters: 7(Integer)
         * 2020-10-15 16:12:09.879 DEBUG 8484 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : <==      Total: 1
         * {"age":75,"id":7,"name":"07a843f8-574d-49bd-a932-0d9970903da3","no":"ec22ca5d-d321-4984-b91b-21bd8a8fec3e"}
         */
        Optional<Student> student = studentMapper.selectOne(c -> c.where(id, isEqualTo(7)));
        student.ifPresent(value -> System.out.println(JSON.toJSONString(value)));
    }

    @Test
    void select() {
        /*
         * 2020-10-15 16:14:23.599 DEBUG 11348 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : ==>  Preparing: select id, name, age, no from student
         * 2020-10-15 16:14:23.635 DEBUG 11348 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : ==> Parameters:
         * 2020-10-15 16:14:23.671 DEBUG 11348 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : <==      Total: 3
         * {"age":75,"id":7,"name":"07a843f8-574d-49bd-a932-0d9970903da3","no":"ec22ca5d-d321-4984-b91b-21bd8a8fec3e"}
         * {"age":45,"id":8,"name":"d51e073c-2db2-439f-b8c8-adfe136c941f","no":"160be462-7147-463b-bd35-ba5b46048cd9"}
         * {"age":31,"id":9,"name":"eda64368-fc1f-4f72-8d77-96c7959084f9","no":"a6833a99-418c-4301-8b9a-01ddaacb7368"}
         */
        List<Student> select = studentMapper.select(c -> c);
        select.forEach(value -> System.out.println(JSON.toJSONString(value)));
    }

    @Test
    void selectDistinct() {
        /*
         * 2020-10-15 16:15:38.612 DEBUG 17324 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : ==>  Preparing: select distinct id, name, age, no from student
         * 2020-10-15 16:15:38.643 DEBUG 17324 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : ==> Parameters:
         * 2020-10-15 16:15:38.677 DEBUG 17324 --- [           main] c.l.m.mapper.StudentMapper.selectMany    : <==      Total: 3
         * {"age":75,"id":7,"name":"07a843f8-574d-49bd-a932-0d9970903da3","no":"ec22ca5d-d321-4984-b91b-21bd8a8fec3e"}
         * {"age":45,"id":8,"name":"d51e073c-2db2-439f-b8c8-adfe136c941f","no":"160be462-7147-463b-bd35-ba5b46048cd9"}
         * {"age":31,"id":9,"name":"eda64368-fc1f-4f72-8d77-96c7959084f9","no":"a6833a99-418c-4301-8b9a-01ddaacb7368"}
         */
        List<Student> select = studentMapper.selectDistinct(c -> c);
        select.forEach(value -> System.out.println(JSON.toJSONString(value)));
    }

    @Test
    void selectByPrimaryKey() {
        /*
         * 2020-10-15 16:16:42.309 DEBUG 12548 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : ==>  Preparing: select id, name, age, no from student where id = ?
         * 2020-10-15 16:16:42.345 DEBUG 12548 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : ==> Parameters: 7(Integer)
         * 2020-10-15 16:16:42.375 DEBUG 12548 --- [           main] c.l.m.mapper.StudentMapper.selectOne     : <==      Total: 1
         * {"age":75,"id":7,"name":"07a843f8-574d-49bd-a932-0d9970903da3","no":"ec22ca5d-d321-4984-b91b-21bd8a8fec3e"}
         */
        Optional<Student> student = studentMapper.selectByPrimaryKey(7);
        student.ifPresent(value -> System.out.println(JSON.toJSONString(value)));
    }

    @Test
    void testUpdate() {
        /*
         * 2020-10-15 18:01:05.761 DEBUG 4900 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==>  Preparing: update student set name = ? where id = ?
         * 2020-10-15 18:01:05.796 DEBUG 4900 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==> Parameters: 啊啊啊(String), 7(Integer)
         * 2020-10-15 18:01:05.809 DEBUG 4900 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : <==    Updates: 1
         */
        studentMapper.update(c -> c.set(name).equalTo("啊啊啊").where(id, isEqualTo(7)));
    }

    @Test
    void updateAllColumns() {
        Student newStudent = getNewStudent();
        newStudent.setId(7);
        UpdateDSL<UpdateModel> updateModelUpdateDSL = StudentMapper.updateAllColumns(newStudent, UpdateDSL.update(student));
    }

    @Test
    void updateSelectiveColumns() {
        Student newStudent = getNewStudent();
        newStudent.setId(7);
        UpdateDSL<UpdateModel> updateModelUpdateDSL = StudentMapper.updateSelectiveColumns(newStudent, UpdateDSL.update(student));
    }

    @Test
    void updateByPrimaryKey() {
        /*
         * 2020-10-15 18:21:21.012 DEBUG 16092 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==>  Preparing: update student set name = ?, age = ?, no = ? where id = ?
         * 2020-10-15 18:21:21.049 DEBUG 16092 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==> Parameters: 5c06a4df-cbbf-42cf-bc97-20ff582507ef(String), 10(Integer), c87e4c36-fb2e-4505-8173-797a7e029f37(String), 7(Integer)
         * 2020-10-15 18:21:21.065 DEBUG 16092 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : <==    Updates: 1
         */
        Student newStudent = getNewStudent();
        newStudent.setId(7);
        studentMapper.updateByPrimaryKey(newStudent);
    }

    @Test
    void updateByPrimaryKeySelective() {
        /*
         * 2020-10-15 18:21:52.894 DEBUG 18452 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==>  Preparing: update student set name = ?, age = ?, no = ? where id = ?
         * 2020-10-15 18:21:52.931 DEBUG 18452 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : ==> Parameters: 4e81dc25-8a81-4023-bcaf-5620f949b6bc(String), 35(Integer), c72e4de4-43e1-4593-a554-ff9c3d95872a(String), 7(Integer)
         * 2020-10-15 18:21:52.945 DEBUG 18452 --- [           main] c.l.mybatis.mapper.StudentMapper.update  : <==    Updates: 1
         */
        Student newStudent = getNewStudent();
        newStudent.setId(7);
        studentMapper.updateByPrimaryKeySelective(newStudent);
    }

    @Test
    void selectLeftJoin() {
        Student newStudent = getNewStudent();
        studentMapper.insert(newStudent);
        Course newCourse = getNewCourse(newStudent.getId());
        courseMapper.insert(newCourse);
        /*
         * 2020-10-16 13:53:02.724 DEBUG 7148 --- [           main] c.l.m.mapper.extend.JoinMapper.select    : ==>  Preparing: select s.id, s.name, s.age, s.no, c.id as courseId, c.grade from student s join course c on s.id = c.student_id
         * 2020-10-16 13:53:02.724 DEBUG 7148 --- [           main] c.l.m.mapper.extend.JoinMapper.select    : ==> Parameters:
         * 2020-10-16 13:53:02.729 DEBUG 7148 --- [           main] c.l.m.mapper.extend.JoinMapper.select    : <==      Total: 2
         * {"age":30,"courseId":1,"grade":36,"id":23,"name":"211291a4-d69e-4bf2-ad20-65fbff1a58f2","no":"90b80b42-bc2a-4b66-95d3-6c3b22c7b6b0"}
         * {"age":83,"courseId":2,"grade":70,"id":24,"name":"716615db-04df-4b01-b0e6-99d372694436","no":"2888d9ab-e230-411c-b0a1-57559db1b3a5"}
         */
        List<Join> joins = joinMapper.selectAll();
        joins.forEach(System.out::println);
    }

    private Course getNewCourse(int studentId) {
        Course course = new Course();
        course.setStudentId(studentId);
        course.setGrade(new Random().nextInt(100));
        return course;
    }

    private Student getNewStudent() {
        Student student = new Student();
        student.setName(UUID.randomUUID().toString());
        student.setAge(new Random().nextInt(100));
        student.setNo(UUID.randomUUID().toString());
        return student;
    }
}
```

## 参考
- [mybatis官方文档](https://mybatis.org/mybatis-3/zh/project-reports.html)
- [mybatis generator 插件官方文档](http://mybatis.org/generator/configreference/generatedKey.html)
- [mybatis dynamic sql 官方文档](https://mybatis.org/mybatis-dynamic-sql/docs/select.html)
- [mybatis dynamic sql github](https://github.com/mybatis/mybatis-dynamic-sql)



