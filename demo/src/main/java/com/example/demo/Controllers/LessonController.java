package com.example.demo.Controllers;

import com.example.demo.DTO.LessonsDto;
import com.example.demo.Models.Lessons;
import com.example.demo.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/courses/{courseId}/subCourses/{subCourseId}/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<LessonsDto> getAllLessonsOfSubCourse(@PathVariable Integer courseId, @PathVariable Integer subCourseId){
        List<Lessons> lessons = lessonService.getAllLessonsOfSubCourse(courseId,subCourseId);
        return LessonsDto.convertEntityListToDto(lessons);
    }

    @PostMapping
    public ResponseEntity<String> createLesson(@PathVariable Integer courseId, @PathVariable Integer subCourseId, @RequestBody Lessons lesson){
        lessonService.createLesson(courseId,subCourseId,lesson);
        return ResponseEntity.status(HttpStatus.CREATED).body("created lesson sucessfully");
    }

}
