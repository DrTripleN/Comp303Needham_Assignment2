package com.example.nathanielneedham_comp303_assignment2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Programs, String> {
    Programs findByProgramCode(String programCode);
}