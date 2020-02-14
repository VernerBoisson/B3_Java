package com.ynov.api.clients;

import com.ynov.api.entities.GradeStudents;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGradeStudentsClient
{
    @RequestLine("GET /{id}")
    GradeStudents getGradeStudentsById(@Param("id") Long id);
}
