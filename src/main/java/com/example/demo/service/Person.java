package com.example.demo.service;


import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Person {
    String name;
    String[] numbers;
}
