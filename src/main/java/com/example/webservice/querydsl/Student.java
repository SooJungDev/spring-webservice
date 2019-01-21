package com.example.webservice.querydsl;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int academyNo;

    @ManyToOne
    @JoinColumn(name = "academy_id", foreignKey = @ForeignKey(name = "fk_student_academy"))
    private Academy academy;

    @Builder
    public Student(String name, int academyNo) {
        this.name = name;
        this.academyNo = academyNo;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
