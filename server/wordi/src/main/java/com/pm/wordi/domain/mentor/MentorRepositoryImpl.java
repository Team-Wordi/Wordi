package com.pm.wordi.domain.mentor;

import com.pm.wordi.controller.dto.MentorDto;
import com.pm.wordi.domain.BaseStatus;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.pm.wordi.domain.mentor.QMentor.*;
import static com.pm.wordi.domain.mentor.QMentorKeyword.mentorKeyword;
import static com.pm.wordi.domain.user.QUser.user;


public class MentorRepositoryImpl implements MentorRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MentorRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Mentor> searchProfileList(String nationCond, String keywordCond) {
        return queryFactory
                .selectFrom(mentor)
                .join(mentor.user, user).fetchJoin()
                .where(nationEq(nationCond),
                        keywordEq(keywordCond),
                        mentor.status.eq(BaseStatus.ACTIVE))
                .fetch();
    }

    private BooleanExpression keywordEq(String keywordCond) {
        if(keywordCond == null) {
            return null;
        }
        return mentor.mentorKeywordList.contains(
                JPAExpressions
                        .select(mentorKeyword)
                        .from(mentorKeyword)
                        .where(mentorKeyword.keyword.eq(keywordCond), mentor.id.eq(mentorKeyword.mentor.id))
        );
    }


    private Predicate nationEq(String nationCond) {
        return nationCond != null ? mentor.nation.eq(nationCond) : null;
    }



}
