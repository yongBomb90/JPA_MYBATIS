package com.example.demo;

import com.example.demo.jpa.entity.MemberEntity;
import com.example.demo.jpa.entity.TeamEntity;
import com.example.demo.jpa.repository.MemberRepo;
import com.example.demo.jpa.repository.TeamRepo;
import com.example.demo.mybatis.mapper.TeamMapper;
import com.example.demo.mybatis.vo.TeamVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    MemberRepo memberRepo;

    @Test
    void contextLoads() {
        
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName("테스트2");
        MemberEntity memberEntity = MemberEntity.builder()
                .name("사람").birthDay( LocalDateTime.now()).sex(MemberEntity.Sex.M)
                                    .build();
        teamRepo.save(teamEntity);
        memberEntity.setTeam(teamEntity);
        memberRepo.save(memberEntity);
        TeamVO res = teamMapper.selectNow("1");
        System.out.println(res.toString());
    }

    /***
    트랜잭션이 있어여 영속성 
    ***/
    @Test
    @Transactional
    void contextLoads2() {
        MemberEntity memberEntity = memberRepo.getById(2L);
        System.out.println("what?"+memberEntity.getName());

    }

}
