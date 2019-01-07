package com.example.webservice;

import com.example.webservice.querydsl.Academy;
import com.example.webservice.querydsl.AcademyRepository;
import com.example.webservice.querydsl.AcademyRepositorySupport;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;


    @After
    public void tearDown() throws Exception{
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기분_기능_확인(){
        //given
        String name ="soojung";
        String address ="soojung@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));
    }


    @Test
    public void querydsl_custom설정(){
        //given
        String name ="soojung";
        String address ="soojung@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepository.findByName(name);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));
    }


}
