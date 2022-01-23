package com.example.Dem.Courses;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

@Component
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourse()
    {
        return courseRepository.findAll();
    }

public void addNewCourse(Course payload) {

    System.out.println(payload);
    courseRepository.save(payload);
}

public void deleteCourse(Long courseId) {
boolean exists=courseRepository.existsById(courseId);
if(!exists)
{
    throw new IllegalStateException("Id Does not Exists");
}
else
{
    courseRepository.deleteById(courseId);
}

}

public List<Course> getCourseStudents(String name) {
    System.out.println(name);

    System.out.println(courseRepository.findStudentsbyCourse(name));

    return courseRepository.findStudentsbyCourse(name);

}

@Transactional
public void UpdateCourse(Long courseId, String course_name) {

    Course course=courseRepository.findById(courseId).orElseThrow();

    if(course_name!=null && course_name.length()>0 && !Objects.equals(course.getCourse_name(), course_name))
    {
        course.setCourse_name(course_name);
    }

}

public List[] stat()
{

    return new List[] {courseRepository.stat(),courseRepository.statStudent()};

}


}
