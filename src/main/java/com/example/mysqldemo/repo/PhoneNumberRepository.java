package com.example.mysqldemo.repo;

import com.example.mysqldemo.entity.PhoneNumber;
import com.example.mysqldemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    List<PhoneNumber> findPhoneNumbersByStudent(Student student);
}
