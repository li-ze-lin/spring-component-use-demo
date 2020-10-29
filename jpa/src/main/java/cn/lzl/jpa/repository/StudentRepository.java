package cn.lzl.jpa.repository;

import cn.lzl.jpa.entity.Student;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

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
