package com.example.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TeamMapper {

    Map<String,Object> selectNow(String param);



}
