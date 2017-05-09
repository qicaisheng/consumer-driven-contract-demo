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
        return Arrays.asList(new Student(5, "James"));
    }
}
