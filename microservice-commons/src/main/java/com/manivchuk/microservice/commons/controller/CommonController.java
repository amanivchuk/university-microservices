package com.manivchuk.microservice.commons.controller;

import com.manivchuk.microservice.commons.service.CommonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Setter(onMethod_ = @Autowired)
public class CommonController<E, S extends CommonService<E>> {

    protected S service;


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<E> student = service.findById(id);
        if (student.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody E entity) {
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
