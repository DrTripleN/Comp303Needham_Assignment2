package com.example.nathanielneedham_comp303_assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentEnrollmentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;


    double applicationFee = 50.00;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("student", new Student());
        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        Student savedStudent = studentRepository.save(student);
        model.addAttribute("studentId", savedStudent.getStudentId());
        return "redirect:/students/login";
    }
    // Display login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Login page
    }
    // Handle login (implement authentication logic)
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Student student = studentRepository.findByUserNameAndPassword(username, password);
        if (student != null) {
            model.addAttribute("student", student);
            List<Programs> programs = programRepository.findAll();
            model.addAttribute("programs", programs);
            return "programs";
        }
        return "redirect:/students/login";
    }

    // Display programs page
    @GetMapping("/programs")
    public String showPrograms(Model model) {
        List<Programs> programs = programRepository.findAll();
        model.addAttribute("programs", programs);
        return "programs";
    }
    @PostMapping("/programs")
    public String enrollInProgram(@RequestParam String programCode, @RequestParam Long studentId, Model model) {

        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        Programs selectedProgram = programRepository.findByProgramCode(programCode);

        if (existingStudent != null && selectedProgram != null) {

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(existingStudent);
            enrollment.setProgram(selectedProgram);
            enrollment.setStartDate(LocalDate.of(2024, 9, 4));
            enrollment.setAmountPaid(selectedProgram.getFee() + applicationFee);



            // Save the enrollment
            enrollmentRepository.save(enrollment);


            model.addAttribute("enrollment", enrollment);

            System.out.println("Enrollment Details: " + enrollment.toString());

            return "payment";
        }

        return "Enrollment not found";
    }

    @PostMapping("/payment")
    public String processPayment(@ModelAttribute Enrollment enrollment, Model model) {

        model.addAttribute("enrollment", enrollment);

        return "successful";
    }

    @GetMapping("/successful")
    public String showSuccessPage() {
        return "successful";
    }
}