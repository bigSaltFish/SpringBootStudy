package com.frank.dao;

import com.frank.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserPermissionMapper {
    List<Permission> findByUserName(String userName);
}