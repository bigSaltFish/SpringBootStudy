package com.frank.dao;

import com.frank.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRoleMapper {
    List<Role> findByUserName(String userName);
}