package com.ynov.api.services;

import com.ynov.api.clients.IGradeClient;
import com.ynov.api.clients.IGradeStudentsClient;
import com.ynov.api.clients.IStudentClient;
import com.ynov.api.entities.Grade;
import com.ynov.api.entities.GradeStudents;
import com.ynov.api.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Slf4j
@Service
public class apiService
{
    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8081/grades");

    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8082/students");

    private IGradeStudentsClient iGradeStudentsClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudentsClient.class, "http://localhost:8083/gradeStudents");

    public List<Grade> getAllGrades(){
        return iGradeClient.getAll();
    }

    public Grade getGradeById(Long id){
        return iGradeClient.getOneById(id);
    }

    public Grade deleteGradeById(Long id){
        return iGradeClient.deleteById(id);
    }

    public Grade patchGradeById(Long id, Grade grade){
        return iGradeClient.updateById(id, grade);
    }

    public Grade postGrade(Grade grade){return iGradeClient.newGrade(grade); }

    public List<Student> getAllStudents(){
        return iStudentClient.getAll();
    }

    public Student getStudentById(Long id){
        return iStudentClient.getOneById(id);
    }

    public Student deleteStudentById(Long id){
        return iStudentClient.deleteById(id);
    }

    public Student patchStudentById(Long id, Student student){
        return iStudentClient.updateById(id, student);
    }

    public Student postStudent(Student student){
        return iStudentClient.newGrade(student);
    }

    public GradeStudents getGradeStudentsById(Long id){
        return iGradeStudentsClient.getGradeStudentsById(id);
    }
}
