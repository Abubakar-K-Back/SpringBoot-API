package com.example.Dem.Courses;

import java.util.*;

import com.example.Dem.Student.Student;
import com.fasterxml.jackson.databind.ObjectReader;

import java.util.List;

import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

     @Query(value="SELECT c FROM Course c WHERE c.id=?1")
     List<Course> findCoursesByStudent(Long sid);

     @Query(value="SELECT c FROM Course c WHERE c.course_name=?1")
     List<Course> findStudentsbyCourse(String name);

     @Query(value="Select c from Course c")
     List<Course> stat();

     
     @Query(value="Select c from Student c")
     List<Student> statStudent();
}
