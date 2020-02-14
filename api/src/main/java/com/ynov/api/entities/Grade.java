package com.ynov.api.entities;

import lombok.Data;

@Data
public class Grade
{
    private Long id;
    private String title;
    private String headTeacher;
    private int year;
}
