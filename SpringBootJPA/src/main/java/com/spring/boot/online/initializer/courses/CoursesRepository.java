package com.spring.boot.online.initializer.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Integer> {
    public List<Course> findByTopicId(int id);
}
