package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
//    @JsonBackReference
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id")
//    @JsonBackReference
    private Course course;
    private boolean enrolled;
}
