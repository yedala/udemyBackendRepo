package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String description;
//    private String imgurl;
    private double rating;
    @OneToMany (mappedBy = "course", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SubCourses> subCourses;

}
