package com.example.demo;

import com.example.demo.jpa.entity.TeamEntity;
import com.example.demo.jpa.repository.TeamRepo;
import com.example.demo.mybatis.mapper.TeamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {


    @Resource
    TeamMapper teamMapper;

    @Autowired
    TeamRepo teamRepo;

    @Test
    void contextLoads() {

        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName("테스트");

        teamRepo.save(teamEntity);
        Map<String,Object> res = teamMapper.selectNow("1");
        System.out.println(res);




    }

}
