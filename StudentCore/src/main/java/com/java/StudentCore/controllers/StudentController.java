package com.java.StudentCore.controllers;

import com.java.StudentCore.entities.Student;
import com.java.StudentCore.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    List<Student> getAll(){ return studentRepository.findAll(); }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student getOneByStudentId(@PathVariable Long id){
        return studentRepository.findById(id).orElseThrow(() -> new ExpressionException("No student find with id : "+id));
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    Student newStudent(@RequestBody Student newStudent){ return studentRepository.save(newStudent); }

    @PatchMapping(value = "/students/{id}")
    Student patchById(@PathVariable Long id, @RequestBody Student newStudent) { return studentRepository.save(newStudent); }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable Long id){ studentRepository.deleteById(id); }
}
