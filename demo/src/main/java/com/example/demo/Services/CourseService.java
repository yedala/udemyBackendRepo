package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void createNewCourse(Course course){
        courseRepository.save(course);
    }

    @Transactional
    public void updateCourse(Integer Id, String courseName){
        Course course = courseRepository.findById(Id).orElseThrow(
                ()-> new IllegalStateException("not present")
        );
        course.setCourseName(courseName);

    }

    public void deleteCourse(Integer Id){
        courseRepository.deleteById(Id);
    }





}
