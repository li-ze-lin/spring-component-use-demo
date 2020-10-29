package cn.lzl.jpa.repository;

import cn.lzl.jpa.JpaApplicationTests;
import cn.lzl.jpa.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.UUID;

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