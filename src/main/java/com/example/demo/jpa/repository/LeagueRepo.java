package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.LeagueEntity;
import com.example.demo.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LeagueRepo extends JpaRepository<LeagueEntity, Long> {


}
