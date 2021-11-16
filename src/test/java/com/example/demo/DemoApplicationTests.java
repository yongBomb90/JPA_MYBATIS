package com.example.demo;

import com.example.demo.mybatis.mapper.TeamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
class DemoApplicationTests {


    @Resource
    TeamMapper teamMapper;

    @Test
    void contextLoads() {
        String res = teamMapper.selectNow("");

        System.out.println(res);
    }

}
