package com.ynov.api.controllers;

import com.ynov.api.entities.Grade;
import com.ynov.api.entities.GradeStudents;
import com.ynov.api.entities.Student;
import com.ynov.api.services.apiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class apiController
{
    @Autowired
    apiService apiService;

    // Grades
    @RequestMapping(value = "/grades", method= RequestMethod.GET)
    ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(apiService.getAllGrades(), HttpStatus.OK);
    }

    @RequestMapping(value = "/grades/{id}", method= RequestMethod.GET)
    ResponseEntity<Grade> getGradeById(Long id){
        return new ResponseEntity<>(apiService.getGradeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/grades/{id}", method= RequestMethod.DELETE)
    ResponseEntity<Grade> deleteGradeById(Long id){
        return new ResponseEntity<>(apiService.deleteGradeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/grades/{id}", method= RequestMethod.PATCH)
    ResponseEntity<Grade> postGrade(Long id, Grade grade){
        return new ResponseEntity<>(apiService.patchGradeById(id, grade), HttpStatus.OK);
    }

    @RequestMapping(value = "/grades", method= RequestMethod.POST)
    ResponseEntity<Grade> postGrade(Grade grade){
        return new ResponseEntity<>(apiService.postGrade(grade), HttpStatus.OK);
    }

    // Students
    @RequestMapping(value = "/students", method= RequestMethod.GET)
    ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(apiService.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method= RequestMethod.GET)
    ResponseEntity<Student> getStudentById(Long id){
        return new ResponseEntity<>(apiService.getStudentById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method= RequestMethod.DELETE)
    ResponseEntity<Student> deleteStudentById(Long id){
        return new ResponseEntity<>(apiService.deleteStudentById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method= RequestMethod.PATCH)
    ResponseEntity<Student> patchStudentById(Long id, Student student){
        return new ResponseEntity<>(apiService.patchStudentById(id, student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method= RequestMethod.POST)
    ResponseEntity<Student> postStudent(Student student){
        return new ResponseEntity<>(apiService.postStudent(student), HttpStatus.OK);
    }

    // GradeStudents
    @RequestMapping(value = "/gradestudents/{gradeId}", method= RequestMethod.GET)
    ResponseEntity<GradeStudents> getGradeStudentsById(Long gradeId){
        return new ResponseEntity<>(apiService.getGradeStudentsById(gradeId), HttpStatus.OK);
    }
}
