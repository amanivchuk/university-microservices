package com.manivchuk.usersmicroservice.controller;

import com.manivchuk.microservice.commons.controller.CommonController;
import com.manivchuk.usersmicroservice.models.entity.Student;
import com.manivchuk.usersmicroservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

    @PutMapping("/id")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student> optionalStudent = service.findById(id);

        if (optionalStudent.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        Student studentDb = optionalStudent.get();
        studentDb.setFirstName(student.getFirstName());
        studentDb.setLastName(student.getLastName());
        studentDb.setEmail(student.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentDb));
    }
}
