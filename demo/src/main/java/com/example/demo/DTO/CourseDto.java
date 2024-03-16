package com.example.demo.DTO;

import com.example.demo.Models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CourseDto {
    private int id;
    private String courseName;
    private String description;
//    private String imgurl;
    private double rating;

    public static  List<CourseDto> courseEntityToDto (List<Course> courses){
        List<CourseDto> coursesDto = new ArrayList<>();
        courses.forEach(course -> {
            CourseDto cd = new CourseDto();
            cd.setCourseName(course.getCourseName());
            cd.setDescription(course.getDescription());
            cd.setRating(course.getRating());
            cd.setId(course.getId());
            coursesDto.add(cd);
        });
        return coursesDto;
    }

    public static CourseDto convertCourse(Course c){
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(c.getCourseName());
        courseDto.setId(c.getId());
        courseDto.setDescription(c.getDescription());
        courseDto.setRating(c.getRating());
        return courseDto;
    }

}
