package com.example.demo.Controllers;

import com.example.demo.Services.UserCourseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/{userId}/courses/{courseId}/enroll")
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @PostMapping
    public void enrollACourseByUser(@PathVariable Integer userId , @PathVariable Integer courseId){
        userCourseService.enrollACourseByUser(userId,courseId);
    }
}
