package com.example.mysqldemo.service;

import com.example.mysqldemo.entity.PhoneNumber;
import com.example.mysqldemo.entity.Student;
import com.example.mysqldemo.repo.PhoneNumberRepository;
import com.example.mysqldemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return Optional.ofNullable(studentRepository.findById(id)).get().orElseThrow(() -> new RuntimeException(String.format("Student %s not found", id)));
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers(Student student) {
        return phoneNumberRepository.findPhoneNumbersByStudent(student);
    }

    @Override
    public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }
}
