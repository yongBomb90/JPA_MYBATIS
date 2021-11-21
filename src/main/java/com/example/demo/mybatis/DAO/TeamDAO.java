package com.example.demo.mybatis.DAO;

import com.example.demo.mybatis.vo.TeamVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAO {


    @Autowired
    private SqlSession session;

    public TeamVO selectTeamOne(String seq)throws Exception{
        return session.selectOne("com.example.demo.mybatis.mapper.TeamMapper.selectTeamOne",seq);
    }

}
