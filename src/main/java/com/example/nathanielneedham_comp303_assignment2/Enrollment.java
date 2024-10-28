package com.example.nathanielneedham_comp303_assignment2;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationNo")
    private Long applicationNo;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "programCode", nullable = false)
    private Programs program;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "amountPaid", nullable = false)  // matches database column
    private double amountPaid;

    // Default constructor
    public Enrollment() {}

    // Parameterized constructor
    public Enrollment(Student student, Programs program, LocalDate startDate, double amountPaid) {
        this.student = student;
        this.program = program;
        this.startDate = startDate;
        this.amountPaid = amountPaid;
    }

    // Getters and Setters
    public Long getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(Long applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Programs getProgram() {
        return program;
    }

    public void setProgram(Programs program) {
        this.program = program;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Enrollment [applicationNo=" + applicationNo + ", student=" + student + ", program=" + program +
                ", startDate=" + startDate + ", amountPaid=" + amountPaid + "]";
    }
}