package com.ynov.GradeCore.controllers;

import com.ynov.GradeCore.entities.Grade;
import com.ynov.GradeCore.repositories.GradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.expression.ExpressionException;



import java.util.List;

@Controller
@RestController
@Slf4j
public class GradeController
{
    @Autowired
    private GradeRepository gradeRepository;

    @RequestMapping(value= "/grades", method = RequestMethod.GET)
    List<Grade> getAll(){ return gradeRepository.findAll();}

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.GET)
    Grade getOneByStudentId(@PathVariable Long id){

        System.out.println("Retrieving student with id : "+id);
        return gradeRepository.findById(id).orElseThrow(() -> new ExpressionException("No student find with id : "+id));
    }

    @RequestMapping(value = "/grades", method = RequestMethod.POST)
    Grade newGrade(@RequestBody Grade newGrade){ return gradeRepository.save(newGrade); }

    @PatchMapping(value = "/grades/{id}")
    Grade patchById(@PathVariable Long id, @RequestBody Grade newGrade) { return gradeRepository.save(newGrade); }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable Long id){ gradeRepository.deleteById(id); }
}
