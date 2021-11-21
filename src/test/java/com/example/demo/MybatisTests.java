package com.example.demo;

import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.TeamEntity;
import com.example.demo.jpa.repository.LeagueRepo;
import com.example.demo.jpa.repository.MemberRepo;
import com.example.demo.jpa.repository.TeamRepo;
import com.example.demo.mybatis.DAO.TeamDAO;
import com.example.demo.mybatis.mapper.TeamMapper;
import com.example.demo.mybatis.vo.TeamVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class MybatisTests {


    @Autowired
    TeamDAO teamDAO;

    @Test
    void DAO_Test() throws Exception {
        TeamVO team = teamDAO.selectTeamOne("2");
        System.out.println(team);
    }


    @Autowired
    TeamMapper teamMapper;

    @Test
    void Mapper_Test() throws Exception {
        TeamVO team = teamMapper.selectTeamOne("2");
        System.out.println(team);
    }

    @Test
    void Collection_Test() throws Exception {
        TeamVO team = teamMapper.selectTeam(TeamVO.builder().seq(2L).build());
        System.out.println(team);
    }

}
