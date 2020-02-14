package com.ynov.api.clients;

import com.ynov.api.entities.Grade;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGradeClient
{
    @RequestLine("GET /{id}")
    Grade getOneById(@Param("id") Long id);

    @RequestLine("GET /")
    List<Grade> getAll();

    @RequestLine("POST /new")
    Grade newGrade(@RequestBody() Grade grade);

    @RequestLine("DELETE /{id}")
    Grade deleteById(@Param("id") Long id);

    @RequestLine("PATCH /{id}")
    Grade updateById(@Param("id") Long id, @RequestBody() Grade grade);
}
