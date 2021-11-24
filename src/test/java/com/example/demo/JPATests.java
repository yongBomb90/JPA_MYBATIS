package com.example.demo;

import com.example.demo.jpa.entity.Car;
import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.TeamEntity;
import com.example.demo.jpa.projection.LeugueProjection;
import com.example.demo.jpa.repository.CarRepo;
import com.example.demo.jpa.repository.ItemRepo;
import com.example.demo.jpa.repository.LeagueRepo;
import com.example.demo.jpa.repository.TeamRepo;
import com.example.demo.mybatis.DAO.TeamDAO;
import com.example.demo.mybatis.mapper.MemberMapper;
import com.example.demo.mybatis.mapper.TeamMapper;
import com.example.demo.mybatis.vo.MemberVO;
import com.example.demo.mybatis.vo.TeamVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JPA 테스트 구현
 */
@SpringBootTest
class JPATests {


    @Transactional
    @Test
    void JPA_Test() throws Exception {
        TeamEntity teamEntity = teamRepo.save(TeamEntity.builder().name("BombTeam").build()) ;
        teamEntity = teamRepo.getById(teamEntity.getSeq());
        System.out.println(teamEntity);
    }

    @Autowired
    TeamRepo teamRepo;

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Rollback(value = false)
    @Test
    void JPA_Test2() throws Exception {
        // 현재 새로이 생성되어 비영리적 상태이다. 해당데이터는 영속성 컨테스트에 없다
        TeamEntity 비영속상태 = TeamEntity.builder().name("BombTeam").build();
        // 어떠한 쿼리도 일어 나지 않는다.
        비영속상태.setName("변경됨");

        // 비영속적 상태 엔티티가 영속성 컨텍스트에 들어가면서 영속상태로 변경된다.
        TeamEntity 영속상태 =  teamRepo.save(비영속상태) ;
        // 해당 상태일 경우 마지막 영속성 컨텍스트가 사라지기 지전 상태의 엔티티를 데이터 베이스에 저장한다.
        영속상태.setName("영속상태");
        teamRepo.flush();


        // em.clear(); 통해 영속성 컨텍스트가 비워지면서 해당 엔티티는 더이상 컨텍스트에 존재하지 않게 된다.
        em.clear();
        TeamEntity 준영속상태 = 영속상태;
        준영속상태.setName("준영속상태");

        // 마지막 삭제가 이루어지고 해당 객체는 더이상 컨텍스트에 존재하지않으며
        // 다시 영속상태로 가기위해서는 새로 영속성 컨텍스트에 진입(save) 하면서 새로운 Entity가 되어야한다.
        teamRepo.delete(준영속상태);
        TeamEntity 삭제상태 = 준영속상태;
        System.out.println(삭제상태);

    }

    @Autowired
    LeagueRepo leagueRepo;

    @Transactional
    @Rollback(value = false)
    @Test
    void JPA_Test3() throws Exception {
        // 초기 리그의 정보를 가져오기위해 쿼리 실행
        List<LeagueEntity> list = leagueRepo.findAll();
        String str = "";
        for ( LeagueEntity league : list ) {
            // 해당 로직에서는 팀의 정보를 조회하지 않는다.
            str += league.getName();
        }

        for ( LeagueEntity league : list ) {
            // 해당 로직에서는 팀의 정보를 조회하므로 리그별 팀의 정보를 쿼리로 조회한다
            str += league.getTeams().get(0).getName();
        }
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void JPA_Test4() throws Exception {
        LeugueProjection leugueProjection =  leagueRepo.getLeagueEntityByName("K-league");
        System.out.println(leugueProjection.getNickName());
    }


    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CarRepo carRepo;

    @Transactional
    @Rollback(value = false)
    @Test
    void JPA_Test5() throws Exception {
        Car 자식 = new Car();
        자식.setName("K3"); 자식.setBrand("KIA");
        carRepo.save(자식);
        Car 저장된자식 = carRepo.getById(1L);
        assertEquals(저장된자식.getBrand(),"KIA");
    }

}
