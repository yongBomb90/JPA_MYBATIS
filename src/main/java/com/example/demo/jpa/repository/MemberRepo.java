package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.MemberEntity;
import com.example.demo.jpa.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberRepo extends JpaRepository<MemberEntity, Long> {


}
