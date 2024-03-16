package com.example.demo.Controllers;

import com.example.demo.DTO.CourseDto;
import com.example.demo.Models.Course;
import com.example.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<CourseDto> getCourses(){
        List<Course> courses =  courseService.getCourses();
        return CourseDto.courseEntityToDto(courses);
    }

    @PostMapping
    public ResponseEntity<String> newCourse(@RequestBody Course course){

        courseService.createNewCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course Created Successfully");
    }

    @PutMapping (path = "{id}")
    public ResponseEntity<String>  updateCourse(@PathVariable("id") Integer Id, @RequestParam(required = false) String courseName){
        courseService.updateCourse(Id,courseName);
        return ResponseEntity.ok("Course Updated Successfully");
    }
    @DeleteMapping (path = "{id}")
    public void deleteCourse(@PathVariable("id")Integer Id){
        courseService.deleteCourse(Id);
    }
}
