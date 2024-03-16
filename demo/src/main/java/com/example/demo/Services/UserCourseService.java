package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.User;
import com.example.demo.Models.UserCourse;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.UserCourseRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    public void enrollACourseByUser(Integer userId, Integer courseId){
        User user =  userRepository.findById(userId).orElseThrow(
                ()-> new IllegalStateException("user not  present")
        );
        Course course = courseRepository.findById(courseId).orElseThrow(
                ()-> new IllegalStateException("not there course")
        );

        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        userCourse.setEnrolled(true);
        userCourseRepository.save(userCourse);
    }
}
