package com.example.Dem.Student;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )


    private Long id;
    private String name;
    private String cnic;
    private String address;

    public Student()
    {

    }

    public Student(Long id, String name, String cnic, String address) {
        super();
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.address = address;
    }

    public Student( String name, String cnic, String address) {
        super();
        this.name = name;
        this.cnic = cnic;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnic='" + cnic + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
