package com.valerijovich.studentscrudspringbootrestservice.Controller;

import com.valerijovich.studentscrudspringbootrestservice.Exception.StudentNotFoundException;
import com.valerijovich.studentscrudspringbootrestservice.Model.Student;
import com.valerijovich.studentscrudspringbootrestservice.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentsController {

    private final StudentRepository studentRepository;

    @PostMapping("/students")
    public void postStudent(@RequestBody Student studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setYear(studentDto.getYear());
        studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public void putStudent(@PathVariable("id") Long id, @RequestBody Student studentDto) {
        Student student = new Student();
        student.setStudent_id(id);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setYear(studentDto.getYear());
        studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
