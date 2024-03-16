package com.example.demo.Controllers;

import com.example.demo.DTO.CourseDto;
import com.example.demo.Models.Course;
import com.example.demo.Models.User;
import com.example.demo.Models.UserCourse;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping (path ="{userId}/enrolled")
    public List<CourseDto> getAllEnrolledCoursesByUser(@PathVariable Integer userId){
        List<CourseDto> userCourses = userService.getAllEnrolledCoursesByUser(userId);
        return userCourses;
    }

    @PostMapping (path = "create")
    public User createAUser(@RequestBody User user){
        System.out.println("working");
        User res = userService.createAUser(user);
        return res;
    }

}
