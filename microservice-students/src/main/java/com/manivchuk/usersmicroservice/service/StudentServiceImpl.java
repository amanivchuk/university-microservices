package com.manivchuk.usersmicroservice.service;

import com.manivchuk.microservice.commons.service.CommonServiceImpl;
import com.manivchuk.usersmicroservice.models.entity.Student;
import com.manivchuk.usersmicroservice.models.repositories.StudentRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod_ = @Autowired)
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

//    private StudentRepository studentRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public Iterable<Student> findAll() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Student> findById(Long id) {
//        return studentRepository.findById(id);
//    }
//
//    @Override
//    @Transactional()
//    public Student save(Student student) {
//        return studentRepository.save(student);
//    }
//
//    @Override
//    @Transactional()
//    public void deleteById(Long id) {
//        studentRepository.deleteById(id);
//    }
}
