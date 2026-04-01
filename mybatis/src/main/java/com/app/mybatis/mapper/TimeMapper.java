package com.app.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface TimeMapper {
    public String getTime();

    @Select("SELECT CURRENT_TIMESTAMP FROM DUAL")
    public String getTime2();
}
