package com.ynov.api.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Student
{
    private long id;
    private long gradeId;
    private String firstname;
    private String lastname;
    private Date birthdate;
}
