package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import java.util.List;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
    private List<UserCourse> userCourses;
}
