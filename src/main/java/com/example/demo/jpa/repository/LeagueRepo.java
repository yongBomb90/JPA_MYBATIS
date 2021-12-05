package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.MemberEntity;
import com.example.demo.jpa.projection.LeugueProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface LeagueRepo extends JpaRepository<LeagueEntity, Long> {
    LeugueProjection getLeagueEntityByName(String name);

    @EntityGraph(attributePaths = "teams")
    List<LeagueEntity>  findAll();

    @Query(
            value = "SELECT l FROM LeagueEntity l join fetch l.teams"
            ,countQuery = "select count(l.seq) FROM LeagueEntity l"
    )
    Page<LeagueEntity> findAllWithTeam( Pageable pageable);


}
