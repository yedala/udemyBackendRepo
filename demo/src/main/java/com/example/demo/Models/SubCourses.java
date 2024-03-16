package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class SubCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subCourseName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;
    @OneToMany(mappedBy = "subCourse")
    private List<Lessons> lessons;
}
