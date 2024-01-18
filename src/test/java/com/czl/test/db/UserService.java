package com.czl.test.db;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Slf4j
@SpringBootTest
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    JPAQueryFactory query;

    @Autowired
    UserRepository userRepository;


    @DisplayName("전체 조회 테스트")
    @Test
    public void 전체조회() {
        List<UserDTO> all = userMapper.findAll();
        log.info(all.toString());
    }

    @DisplayName("일자(datetime) 저장 테스트")
    @Test
    public void insert_테스트() {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 1, 1, 1);
        Instant instant = dt.atZone(ZoneId.systemDefault()).toInstant();
        User user = new User();
        user.setName("czl");
        user.setAge(18);
        user.setInstantDatetime(instant);
        user.setLocalDatetime(dt);
        userMapper.insert(user);

        List<UserDTO> all = userMapper.findAll();
        log.info("{}", all);
    }

    @Test
    public void BooleanBuilder_테스트() {

        User tempUser = User.builder()
                .name("czl")
                .age(18)
                .instantDatetime(Instant.now())
                .localDatetime(LocalDateTime.now())
                .build();

        User saveUser = userRepository.save(tempUser);


        QUser user = QUser.user;

        BooleanBuilder where = new BooleanBuilder();
//        where.and(user.localDatetime.goe(LocalDateTime.now().minusDays(1)));
//        where.and(user.localDatetime.loe(LocalDateTime.now().plusDays(1)));
//        where.and(user.instantDatetime.goe(Instant.now().minus(Duration.ofDays(1))));
//        where.and(user.instantDatetime.loe(Instant.now().plus(Duration.ofDays(1))));
        where.and(user.localDatetime.goe(LocalDateTime.now().minusMonths(1)));
        where.and(user.localDatetime.loe(LocalDateTime.now().plusMonths(1)));
        where.and(user.instantDatetime.goe(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).minusMonths(1).toInstant()));
        where.and(user.instantDatetime.loe(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).plusMonths(1).toInstant()));
        where.and(user.instantDatetime.goe(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).minusMonths(1).toInstant()));
        where.and(user.instantDatetime.loe(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).plusMonths(1).toInstant()));

        List<User> findUser = query
                .select(user)
                .from(user)
                .where(where)
                .fetch();

        log.info("findUser : {}", findUser);

    }




}
