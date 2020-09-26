package com.manivchuk.usersmicroservice.models.repositories;

import com.manivchuk.usersmicroservice.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
