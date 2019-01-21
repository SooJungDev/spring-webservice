package com.example.webservice;

import com.example.webservice.querydsl.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class subQueryTest {

    @Autowired
    private AcademyRepository academyRepository;


    @Autowired
    private StudentRepository studentRepository;


    @After
    public void tearDown() throws Exception {
        studentRepository.deleteAll();
        academyRepository.deleteAll();
    }

    @Test
    public void  SELECT절_서브쿼리로_사용된다(){
        //given
        String academyName1 = "name1";
        Academy academy1 = Academy.builder()
                .address("address1")
                .name(academyName1)
                .build();

        academy1.addStudent(Arrays.asList(
                new Student("student1",1),
                new Student("student2", 2)
        ));

        String academyName2= "name2";
        Academy academy2 = Academy.builder()
                .address("address2")
                .name(academyName2)
                .build();

        academy2.addStudent(Arrays.asList(
                new Student("student3",3),
                new Student("student4", 4),
                new Student("student5",5)
        ));

        academyRepository.saveAll(Arrays.asList(academy1,academy2));

        //when
        List<StudentCount> result = academyRepository.findAllStudentCount();

        //then
        assertThat(result.get(0).getAcademyName(), is(academyName1));
        assertThat(result.get(1).getAcademyName(), is(academyName2));


    }
}
