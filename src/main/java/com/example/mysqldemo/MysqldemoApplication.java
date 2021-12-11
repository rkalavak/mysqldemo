package com.example.mysqldemo;

import com.example.mysqldemo.entity.PhoneNumber;
import com.example.mysqldemo.entity.Student;
import com.example.mysqldemo.repo.PhoneNumberRepository;
import com.example.mysqldemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MysqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqldemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PhoneNumberRepository phoneNumberRepository) {
		return args -> {
			Student student = Student.builder().studentId(1).studentName("Ram").build();
			PhoneNumber phoneNumber1 = PhoneNumber.builder().phoneId(1).phoneNumber("9945944331").student(student).build();
			PhoneNumber phoneNumber2 = PhoneNumber.builder().phoneId(2).phoneNumber("9686597622").student(student).build();
			phoneNumberRepository.save(phoneNumber1);
			phoneNumberRepository.save(phoneNumber2);
			log.info("Data has been saved");
		};
	}
}
