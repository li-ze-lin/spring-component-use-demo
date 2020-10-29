# springframework data jpa 使用演示

## 基于springboot的基础上引入
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## 实体
```java
/**
  * 实体 需要加 @Entity 注解
  */
@Entity
public class Student {

    /**
     * 主键 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    /**
     * 唯一键
     */
    @Column(unique = true)
    private String no;
}
```

## DAO
```java
/**
 * dao 需要继承JpaRepositoryImplementation
 */
@Repository
public interface StudentRepository extends JpaRepositoryImplementation<Student, Integer> {

    /**
     * 自定义查询
     * select *from student where no = ? 
     */
    Student findByNo(String no);
}
```

## 使用
```java
class StudentRepositoryTest extends JpaApplicationTests {

    @Resource
    private StudentRepository studentRepository;

    @Test
    public void add() {
        String no = getNo();
        studentRepository.save(new Student(null, "1", 10, no));

        Student student = studentRepository.findOne(Example.of(Student.builder().no(no).build())).get();
        System.out.println(student);
        Assertions.assertEquals(student.getNo(), no);
    }

    @Test
    public void update() {
        String no = getNo();
        studentRepository.save(new Student(null, "1", 10, no));

        Student student = studentRepository.findOne(Example.of(Student.builder().no(no).build())).get();
        student.setAge(20);
        studentRepository.save(student);

        Student student1 = studentRepository.findOne(Example.of(Student.builder().no(no).build())).get();
        System.out.println(student1);
        Assertions.assertEquals(student1.getAge(), 20);
    }

    @Test
    public void deleteOne() {
        String no = getNo();
        studentRepository.save(new Student(null, "1", 10, no));
        Student student = studentRepository.findOne(Example.of(Student.builder().no(no).build())).get();
        System.out.println(student);
        Assertions.assertEquals(student.getNo(), no);

        studentRepository.delete(student);
        Optional<Student> one = studentRepository.findOne(Example.of(Student.builder().no(no).build()));
        Assertions.assertFalse(one.isPresent());
    }

    @Test
    public void deleteAll() {
        studentRepository.save(new Student(null, "1", 10, getNo()));
        studentRepository.deleteAll();
        Assertions.assertEquals(0, studentRepository.count());
    }

    @Test
    public void selectPage() {
        studentRepository.save(new Student(null, "1", 30, getNo()));
        studentRepository.save(new Student(null, "1", 30, getNo()));
        Page<Student> all = studentRepository.findAll(Example.of(Student.builder().age(30).build()), PageRequest.of(0, 1));
        all.forEach(System.out::println);
        Assertions.assertEquals(all.getContent().size(), 1);
    }

    @Test
    public void selectExpand() {
        String no = getNo();
        studentRepository.save(new Student(null, "1", 10, no));

        Student byNo = studentRepository.findByNo(no);
        System.out.println(byNo);
        Assertions.assertEquals(no, byNo.getNo());
    }

    private String getNo() {
        return UUID.randomUUID().toString();
    }
}
```





