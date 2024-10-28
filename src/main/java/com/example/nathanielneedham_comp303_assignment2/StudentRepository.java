package com.example.nathanielneedham_comp303_assignment2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUserNameAndPassword(String userName, String password);
}