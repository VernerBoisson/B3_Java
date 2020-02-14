package com.ynov.api.clients;

import com.ynov.api.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "StudentClient")
public interface IStudentClient {
    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Long id);

    @RequestLine("GET /")
    List<Student> getAll();

    @RequestLine("POST /new")
    Student newGrade(@RequestBody() Student grade);

    @RequestLine("DELETE /{id}")
    Student deleteById(@Param("id") Long id);

    @RequestLine("PATCH /{id}")
    Student updateById(@Param("id") Long id, @RequestBody() Student grade);
}
