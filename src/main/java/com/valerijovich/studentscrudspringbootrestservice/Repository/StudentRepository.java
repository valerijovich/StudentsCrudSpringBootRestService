package com.valerijovich.studentscrudspringbootrestservice.Repository;

import com.valerijovich.studentscrudspringbootrestservice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
