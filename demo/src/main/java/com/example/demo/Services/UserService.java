package com.example.demo.Services;

import com.example.demo.DTO.CourseDto;
import com.example.demo.DTO.UserCourseDTO;
import com.example.demo.Models.Course;
import com.example.demo.Models.User;
import com.example.demo.Models.UserCourse;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.UserCourseRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCourseRepository userCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    public List<CourseDto> getAllEnrolledCoursesByUser(Integer userId){
        List<UserCourse> userCourses = userCourseRepository.findByUserIdAndEnrolled(userId,true);

        List<CourseDto> courses = new ArrayList<>();
        for(UserCourse userCourse: userCourses ){
            System.out.println(userCourse.getCourse().getId());
            Course course = courseRepository.findById(userCourse.getCourse().getId()).orElseThrow(
                    ()-> new IllegalStateException("not present")
            );
            courses.add(CourseDto.convertCourse(course));
        }

        return courses;
    }

    public User createAUser(User user){
        userRepository.save(user);
        return user;
    }

}
