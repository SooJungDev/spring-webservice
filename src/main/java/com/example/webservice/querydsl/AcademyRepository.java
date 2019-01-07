package com.example.webservice.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy,Long>, AcademyRepositoryCustom {
}
