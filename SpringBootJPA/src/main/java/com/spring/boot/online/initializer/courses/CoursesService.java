package com.spring.boot.online.initializer.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    private List<Course> coursesList;

    public List<Course> getAllCourseByTopic(int id){
        coursesList = new ArrayList<>();
        coursesRepository.findByTopicId(id).forEach(coursesList::add);
        return coursesList;
    }

    public Optional<Course> getAllCourseById(int id, final int idCourse) {
        return  coursesRepository.findById(id);
    }

    public void addCourse(Course course) {
        coursesRepository.save(course);
    }

    public void updateCourse(Course course, int id) {
        coursesRepository.save(course);
    }

    public void deleteCourse(Course course, int id) {
        coursesRepository.deleteById(id);
    }
}
