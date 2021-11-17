package com.example.demo.jpa.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of="seq")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEAM")
public class TeamEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "NAME" , unique = true , nullable = false)
    private String name; // 로그인 아이디



}
