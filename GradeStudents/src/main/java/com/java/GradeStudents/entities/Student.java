package com.java.GradeStudents.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private long id;
    private long grade;
    private String firstname;
    private String lastname;
    private Date birthdate;

}
