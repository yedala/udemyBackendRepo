package com.example.demo.Controllers;

import com.example.demo.Models.SubCourses;
import com.example.demo.Services.SubCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/courses/{courseId}/subCourses")
public class SubCourseController {
    @Autowired
    private SubCourseService subCourseService;

    @GetMapping
    public ResponseEntity<List<SubCourses>> getAllSubCourses(@PathVariable Integer courseId){
        List<SubCourses> subCourses = subCourseService.getAllSubCourses(courseId);
        return  ResponseEntity.ok(subCourses);
    }

    @PostMapping
    public ResponseEntity<SubCourses>  createSubCourse(@PathVariable Integer courseId , @RequestBody SubCourses sCourse){
        SubCourses subCourse = subCourseService.createSubCourses(courseId ,sCourse);
        return ResponseEntity.ok(subCourse);
    }
}
