package com.ynov.api.entities;

import lombok.Data;

import java.util.List;

@Data
public class GradeStudents
{
    private Grade grade;
    private List<Student> students;
}
