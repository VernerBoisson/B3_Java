package com.java.GradeStudents.controllers;

import com.java.GradeStudents.entities.GradeStudentsDTO;
import com.java.GradeStudents.service.GradeStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeStudentsController {

    @Autowired
    GradeStudentsService gradeStudentsService;

    @RequestMapping("/gradeStudents/{gradeId}")
    ResponseEntity<GradeStudentsDTO> getGradeStudents(@PathVariable long gradeId){
        return new ResponseEntity<>(gradeStudentsService.getGradeStudents(gradeId), HttpStatus.OK);
    }
}
