package com.example.webservice.querydsl;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.webservice.querydsl.QAcademy.academy;
import static com.example.webservice.querydsl.QStudent.student;
import static com.querydsl.core.types.ExpressionUtils.count;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

    /**
     * ExpressionUtils는 Querydsl 내부에서 새로운 Expression을 사용 할 수 있도록 지원
     * as를 통해 서브쿼리의 결과물을 alias 시킴
     * 예전에는 JPAExpressions를 통해 서브쿼리를 생성 
     * @return
     */
    @Override
    public List<StudentCount> findAllStudentCount() {
        return queryFactory
                .select(Projections.fields(StudentCount.class,
                        academy.name.as("academyName"),
                        ExpressionUtils.as(
                                JPAExpressions.select(count(student.id))
                                        .from(student)
                                        .where(student.academy.eq(academy)),
                                "studentCount")
                ))
                .from(academy)
                .fetch();
    }

    @Override
    public List<Academy> findAllByStudentId(long studentId) {
        return queryFactory
                .selectFrom(academy)
                .where(academy.id.in(
                        JPAExpressions
                                .select(student.academy.id)
                                .from(student)
                                .where(student.id.eq(studentId))))
                .fetch();
    }
}
