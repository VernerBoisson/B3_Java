package com.java.GradeStudents.service;

import com.java.GradeStudents.clients.IGradeClient;
import com.java.GradeStudents.clients.IStudentClient;
import com.java.GradeStudents.entities.Grade;
import com.java.GradeStudents.entities.GradeStudentsDTO;
import com.java.GradeStudents.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@EnableFeignClients
@Data
@Slf4j
@Service
public class GradeStudentsService {

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

    public GradeStudentsDTO getGradeStudents(Long gradeId){
        System.out.println("Call to the grade client - getOneById : "+ gradeId);
        Grade grade = iGradeClient.getOneById(gradeId);

        System.out.println("Call to the student client - getAll");
        List<Student> gradeStudents = iStudentClient.getAll()
                .stream()
                .filter(stud -> stud.getGrade() == gradeId)
                .collect(Collectors.toList());

        return new GradeStudentsDTO(grade, gradeStudents);
    }
}
