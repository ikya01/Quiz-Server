package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        if (courseRepository.existsById(id)) {
            updatedCourse.setId(id);
            return courseRepository.save(updatedCourse);
        }
        return null; // Gérer le cas où le cours n'existe pas
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
