package com.example.demo;

import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.MemberEntity;
import com.example.demo.jpa.entity.TeamEntity;
import com.example.demo.jpa.repository.LeagueRepo;
import com.example.demo.jpa.repository.MemberRepo;
import com.example.demo.jpa.repository.TeamRepo;
import com.example.demo.mybatis.mapper.TeamMapper;
import com.example.demo.mybatis.vo.TeamVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {


    @Resource
    TeamMapper teamMapper;

    @Test
    void contextLoads() {
//        TeamVO param = new TeamVO();
//        param.setSeq(2L);
//        TeamVO teamVO = teamMapper.selectTeam(param);
//        System.out.println(teamVO);
    }



    @Autowired
    TeamRepo teamRepo;

    @Autowired
    MemberRepo memberRepo;

    @Autowired
    LeagueRepo leagueRepo;


    /***
    트랜잭션이 있어여 영속성
    ***/
    @Test
    @Transactional
    @Rollback(value = false)
    void contextLoads2() {
        TeamEntity teamEntity = teamRepo.getById(2L);
        LeagueEntity league = LeagueEntity.builder().name("리그앙").
                                build();

        league = leagueRepo.save(league);



    }


}
