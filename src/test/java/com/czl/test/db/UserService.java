package com.czl.test.db;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@SpringBootTest
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        List<UserDTO> all = userMapper.findAll();
        log.info(all.toString());
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("czl");
        user.setAge(18);
        user.setInstantDatetime(Instant.now());
        user.setLocalDatetime(LocalDateTime.now());
        userMapper.insert(user);

        List<UserDTO> all = userMapper.findAll();
        log.info("{}", all);
    }
}
