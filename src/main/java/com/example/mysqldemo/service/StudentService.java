package com.example.mysqldemo.service;

import com.example.mysqldemo.entity.PhoneNumber;
import com.example.mysqldemo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(int id);
    Student saveStudent(Student student);
    List<PhoneNumber> getPhoneNumbers(Student student);
    PhoneNumber savePhoneNumber(PhoneNumber phoneNumber);
}
