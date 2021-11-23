package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Item;
import com.example.demo.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ItemRepo extends JpaRepository<Item, Long> {


}
