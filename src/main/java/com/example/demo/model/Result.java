package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;



    private int score;

    @NotBlank
    private String subject;

    private int totalQuestions;

    // Constructeurs, getters et setters

    public Result() {
    }

    public Result(String username, int score, String subject, int totalQuestions) {
        this.username = username;

        this.score = score;
        this.subject = subject;
        this.totalQuestions = totalQuestions;
    }

    // Getters et Setters
}
