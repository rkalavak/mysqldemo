package com.example.mysqldemo.controller;

import com.example.mysqldemo.entity.PhoneNumber;
import com.example.mysqldemo.entity.Student;
import com.example.mysqldemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("all")
    public List<Student> getStudents() {
        List<Student> students = studentService.getStudents();
        students.forEach(student -> {
            log.info(student.getStudentId() + " - " + student.getStudentName());
            student.getPhoneNumbers().forEach(phoneNumber -> {
                log.info(phoneNumber.getPhoneId() + " - " + phoneNumber.getPhoneNumber());
            });
        });
        return null;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("phonenumbers")
    public List<PhoneNumber> getPhoneNumbers(@RequestBody Student student) {
        List<PhoneNumber> phoneNumbers = studentService.getPhoneNumbers(student);
        phoneNumbers.forEach(phoneNumber -> {
            log.info(phoneNumber.getPhoneId() + " - " + phoneNumber.getPhoneNumber());
        });
        return null;
    }
}
