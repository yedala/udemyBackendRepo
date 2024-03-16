package com.example.demo.Repository;

import com.example.demo.Models.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse,Integer> {
    List<UserCourse> findByUserIdAndEnrolled(Integer userId, boolean enroll);
}
