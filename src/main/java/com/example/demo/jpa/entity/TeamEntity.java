package com.example.demo.jpa.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of="seq")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEAM")
public class TeamEntity {

    @ManyToOne(targetEntity = LeagueEntity.class)
    @JoinColumn(name = "LEAGUE_SEQ")
    private LeagueEntity league;

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "NAME" , unique = true , nullable = false)
    private String name; // 로그인 아이디


}
