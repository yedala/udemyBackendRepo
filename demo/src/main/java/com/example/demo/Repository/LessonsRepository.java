package com.example.demo.Repository;

import com.example.demo.Models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Integer> {
    @Query("SELECT l FROM Lessons l WHERE l.course.id = :courseId AND l.subCourse.id = :subCourseId")
    List<Lessons> findBycourseidAndsubcourseid(Integer courseId, Integer subCourseId);

}
