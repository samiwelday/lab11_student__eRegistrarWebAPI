package edu.miu.cs.cs425.studenteregistrarapi.repository;

import edu.miu.cs.cs425.studenteregistrarapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
