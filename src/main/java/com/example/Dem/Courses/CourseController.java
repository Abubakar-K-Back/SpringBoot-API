package com.example.Dem.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses()
    {
        return courseService.getCourse();
    }
    @PostMapping
    public void RegisterCourse(@RequestBody Course payload)
    {
     
       courseService.addNewCourse(payload);

    }
    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId)
    {
        courseService.deleteCourse(courseId);
    }
    
    @GetMapping(path = "/CourseStudents")
    public List<Course> getStudentsCourse(@RequestParam String name)
    {

        return courseService.getCourseStudents(name);


    }

    @PutMapping(path="{sid}")
    public void updateCourse(@PathVariable("sid") Long CourseId, @RequestParam(required = false) String course_name)
    {
        System.out.println(CourseId+"-new name: "+course_name);
        courseService.UpdateCourse(CourseId,course_name);
    }

    @GetMapping(path = "/stat")
    public List[] stat()
    {
        return courseService.stat();
        

    }

    

}
