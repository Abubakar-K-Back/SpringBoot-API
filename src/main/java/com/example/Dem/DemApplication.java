package com.example.Dem;

import com.example.Dem.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemApplication.class, args);
	}


}
