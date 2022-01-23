package com.example.Dem.Courses;


import javax.persistence.*;

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long sid;
    private Long id;
    private String course_name;

    public Course()
    {}

    public Course(Long sid, Long id, String course_name) {
        this.sid = sid;
        this.id = id;
        this.course_name = course_name;
    }
    public Course( Long id, String course_name) {
        this.id = id;
        this.course_name = course_name;
    }


    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
