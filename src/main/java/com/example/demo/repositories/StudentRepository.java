package com.example.demo.repositories;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value ="select * from Student  where teacher_id=:id",nativeQuery =true)
     List<Student> allTeacherStudents(int id);
}
