package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("SELECT DISTINCT q.subject FROM Question q")
    List<String> findDistinctSubject();

    List<Question> findBySubject(@Param("subject") String subject);


    Page<Question> findBySubject(String subject, Pageable pageable);
}
