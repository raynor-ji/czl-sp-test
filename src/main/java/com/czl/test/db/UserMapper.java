package com.czl.test.db;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> findAll();

    int insert(User user);
}
