package com.example.Dem.Student;

import org.springframework.stereotype.Component;

import lombok.var;

import java.util.*;

import javax.transaction.Transactional;

import com.example.Dem.Courses.Course;
import com.example.Dem.Courses.CourseRepository;
@Component
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;
    }

    public List<Student> GetStudents()
    {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {


        System.out.println(student);
        studentRepository.save(student);
    }

    
    public void deleteStudent(Long studentId) {
    boolean exist=studentRepository.existsById(studentId);
    
    studentRepository.findAll();

    if(!exist)
    {
        throw new IllegalStateException("Student id does not Exists");
    }
    else
    {
        studentRepository.deleteById(studentId);
        
    }

}

    public List<Course> getStudentCourses(Long sid) {
    
        
        return courseRepository.findCoursesByStudent(sid);
        

    }


    @Transactional
    public void UpdateStudent(Long studentId, String name, String cnic, String address) {
    
        Student student =studentRepository.findById(studentId).orElseThrow();

        if(studentId!=null && name.length()>0 && !Objects.equals(student.getName(), name))
            student.setName(name);

        if(studentId!=null && cnic.length()>0 && !Objects.equals(student.getCnic(), cnic))
            student.setCnic(cnic);

        if(studentId!=null && address.length()>0 && !Objects.equals(student.getAddress(), address))
            student.setAddress(address);

        



    }
}
