package com.spring.boot.online.initializer.courses;

import com.spring.boot.online.initializer.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses(@PathVariable ("param") int id){
        return coursesService.getAllCourseByTopic(id);
    }

    @RequestMapping("/topics/{param}/courses/{id}")
    public Optional<Course> getAllCoursesById(@PathVariable("param") int id, @PathVariable ("id") int idCourse){
        return coursesService.getAllCourseById(id, idCourse);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{param}/courses/{courseId}")
    public void addCourse(@RequestBody Course course, @PathVariable("param") int topicId, @PathVariable String courseId){
        course.setTopic(new Topic(topicId,"",""));
        coursesService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{param}/courses/{idParam}")
    public void updateCourse(@RequestBody Course course, @PathVariable("param")int id, @PathVariable ("idParam") int paramId){
         coursesService.updateCourse(course, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{param}")
    public void deleteCourse(@RequestBody Course course, @PathVariable("param")int id){
        coursesService.updateCourse(course, id);
    }
}
