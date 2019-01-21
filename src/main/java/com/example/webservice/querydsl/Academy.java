package com.example.webservice.querydsl;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academy")
    private List<Student> students = new ArrayList<>();

    @Builder
    public Academy(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addStudent(List<Student> students) {
        for (Student student : students) {
            addStudent(student);
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setAcademy(this);
    }
}
