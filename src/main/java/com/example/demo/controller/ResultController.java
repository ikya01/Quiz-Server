package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/results")
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.getAllResults();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Result result = resultService.getResultById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Result> saveResult(@RequestBody Result result) {
        Result savedResult = resultService.addResult(result);
        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
