package com.java.GradeStudents.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeStudentsDTO {
    private Grade grade;
    private List<Student> students;
}
