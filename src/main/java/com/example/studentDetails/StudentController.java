package com.example.studentDetails;

import com.example.studentDetails.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList; import java.util.List;




@Controller
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/view-student")
    public String viewStudents(Model model) {
        model.addAttribute("students", students);
        return "view-student";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        student.setId(students.size() + 1);
        students.add(student);
        return "redirect:/";
    }
}