package com.ynov.GradeCore.repositories;

import com.ynov.GradeCore.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>
{
}
