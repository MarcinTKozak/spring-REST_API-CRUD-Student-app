package com.example.demo.manager;

import com.example.demo.dao.StudentRepo;
import com.example.demo.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentManager {

    private StudentRepo studentRepo;

    @Autowired
    public StudentManager(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Student(1L, 7656767L, "Marcin Kozak", "marcin.t.kozak@gmail.com"));
    }
}
