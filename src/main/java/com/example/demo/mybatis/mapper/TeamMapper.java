package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.vo.TeamVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {
    TeamVO selectTeamOne(String seq);

    TeamVO selectTeam(TeamVO param);


}
