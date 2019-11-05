package com.frank.dao;

import com.frank.model.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SysLogMapper {
    void save(SysLog sysLog);
}
