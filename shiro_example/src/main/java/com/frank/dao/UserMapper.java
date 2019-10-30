package com.frank.dao;

import com.frank.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User findByUserName(String userName);
}