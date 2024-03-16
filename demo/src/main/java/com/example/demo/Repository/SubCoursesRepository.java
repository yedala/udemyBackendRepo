package com.example.demo.Repository;

import com.example.demo.Models.SubCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCoursesRepository extends JpaRepository<SubCourses,Integer> {
     List<SubCourses> findBycourseId(Integer courseId);
}
