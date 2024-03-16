package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Lessons;
import com.example.demo.Models.SubCourses;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.LessonsRepository;
import com.example.demo.Repository.SubCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonsRepository lessonsRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SubCoursesRepository subCoursesRepository;

    public List<Lessons> getAllLessonsOfSubCourse(Integer courseId, Integer subCourseId){
        return lessonsRepository.findBycourseidAndsubcourseid(courseId,subCourseId);
    }
    public void createLesson(Integer courseId, Integer subCourseId,Lessons lesson){
        Course course = courseRepository.findById(courseId).orElseThrow(
                ()->new IllegalStateException("course not present")
        );

        SubCourses subCourse = subCoursesRepository.findById(subCourseId).orElseThrow(
                ()->new IllegalStateException("subcourse  not present")
        );
        lesson.setCourse(course);
        lesson.setSubCourse(subCourse);
        lessonsRepository.save(lesson);
    }
}
