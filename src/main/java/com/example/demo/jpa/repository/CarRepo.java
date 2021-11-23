package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Car;
import com.example.demo.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CarRepo extends JpaRepository<Car, Long> {


}
