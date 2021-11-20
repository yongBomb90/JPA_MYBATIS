package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.vo.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TeamMapper {

    TeamVO selectTeam(TeamVO param);



}
