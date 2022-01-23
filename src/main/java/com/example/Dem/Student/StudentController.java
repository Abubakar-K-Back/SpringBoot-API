package com.example.Dem.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Dem.Courses.Course;
import com.example.Dem.Student.Student;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello()
    {
        return studentService.GetStudents();
    }


    @PostMapping
    public void RegisterStudent(@RequestBody Student payload)
    {
        studentService.addNewStudent(payload);

//        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Long studentId)
    {
        System.out.println(studentId);  
        studentService.deleteStudent(studentId);
    }
    

    @GetMapping(path = "/studentCourses")
    public List<Course> getStudentCourses(@RequestParam Long sid)
    {
        return studentService.getStudentCourses(sid);

    }

    @PutMapping(path="{id}")
    public void updateStudent(
        @PathVariable("id") Long StudentId, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String cnic,
        @RequestParam(required = false) String address
    )
    {
        System.out.println(StudentId+"-new name: "+name+"-cnic-"+cnic+"-address-"+address);
        studentService.UpdateStudent(StudentId,name,cnic,address);
    }



}
