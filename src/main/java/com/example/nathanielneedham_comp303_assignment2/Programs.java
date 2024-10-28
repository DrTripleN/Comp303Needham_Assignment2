package com.example.nathanielneedham_comp303_assignment2;

import jakarta.persistence.*;

@Entity
@Table(name = "Programs")
public class Programs {

    @Id
    @Column(name = "programCode")
    private String programCode;

    @Column(name = "programName", nullable = false)
    private String programName;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "fee", nullable = false)
    private double fee;

    @Column(name = "professor")
    private String professor;


    public Programs() {}


    public Programs(String programCode, String programName, String duration, double fee, String professor) {
        this.programCode = programCode;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.professor = professor;
    }

    // Getters and Setters
    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Program [programCode=" + programCode + ", programName=" + programName + ", duration=" + duration +
                ", fee=" + fee + ", professor=" + professor + "]";
    }
}