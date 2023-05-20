package com.example.demo.api;

import com.example.demo.dao.entity.Student;
import com.example.demo.manager.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentApi {

    private StudentManager studentManger;


    @Autowired
    public StudentApi(StudentManager studentManger) {
        this.studentManger = studentManger;
    }

    @GetMapping("/all")
    public Iterable<Student> getAll() {
        return studentManger.findAll();
    }

    @GetMapping
    public Optional<Student> getById(@RequestParam Long index) {
        return studentManger.findById(index);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentManger.save(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentManger.save(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Long index) {
        studentManger.deleteById(index);
    }
}
