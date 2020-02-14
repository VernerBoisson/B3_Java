package com.java.GradeStudents.clients;

import com.java.GradeStudents.entities.Grade;
import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET /{id}")
    Grade getOneById(@Param("id") Long id);
    @RequestLine("GET /")
    List<Grade> getAll();
}
