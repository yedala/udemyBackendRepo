package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Entity
@Setter
@Getter
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lessonName;
    private String description;
    private String content;
    @ManyToOne
    @JoinColumn(name = "subCourse_id")
    @JsonBackReference
    private SubCourses subCourse;
    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

}
