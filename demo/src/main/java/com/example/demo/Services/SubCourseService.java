package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.SubCourses;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.SubCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCourseService {

    @Autowired
    private SubCoursesRepository subCoursesRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<SubCourses> getAllSubCourses(Integer courseId){
        List<SubCourses> subCourses = subCoursesRepository.findBycourseId(courseId);
        return subCourses;
    }

    public SubCourses createSubCourses(Integer courseId, SubCourses sCourse){
        Course course = courseRepository.findById(courseId).orElseThrow(
                ()-> new IllegalStateException("not present")
        );
        sCourse.setCourse(course);
        SubCourses res = subCoursesRepository.save(sCourse);
        return res;
    }

}
