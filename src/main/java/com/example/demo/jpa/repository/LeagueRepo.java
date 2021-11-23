package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.MemberEntity;
import com.example.demo.jpa.projection.LeugueProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface LeagueRepo extends JpaRepository<LeagueEntity, Long> {
    LeugueProjection getLeagueEntityByName(String name);

    @EntityGraph(attributePaths = "teams")
    List<LeagueEntity>  findAll();

}
