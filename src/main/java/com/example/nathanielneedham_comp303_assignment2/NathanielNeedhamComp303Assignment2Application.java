package com.example.nathanielneedham_comp303_assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.nathanielneedham_comp303_assignment2")
public class NathanielNeedhamComp303Assignment2Application  implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public static void main(String[] args) {
        SpringApplication.run( NathanielNeedhamComp303Assignment2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("All Students: ");
        studentRepository.findAll().forEach(student -> System.out.println(student));

        System.out.println("\nAll Programs: ");
        programRepository.findAll().forEach(program -> System.out.println(program));

        System.out.println("\nAll Enrollments: ");
        enrollmentRepository.findAll().forEach(enrollment -> System.out.println(enrollment));
    }
}
