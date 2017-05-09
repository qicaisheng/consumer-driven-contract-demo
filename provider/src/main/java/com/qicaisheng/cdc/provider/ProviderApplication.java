package com.qicaisheng.cdc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class ProviderApplication {

    public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

    @RequestMapping(value = "/students", produces = "application/json;charset=UTF-8")
    public List<Student> getStudents() {
        Student student = new Student();
        student.setId(5);
        student.setName("James");
        student.setAge(18);

        return Arrays.asList(student);
    }
}
