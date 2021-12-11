package com.example.mysqldemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private int studentId;
    private String studentName;
    @OneToMany(mappedBy = "student")
    private List<PhoneNumber> phoneNumbers;
}
