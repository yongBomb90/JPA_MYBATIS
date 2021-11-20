package com.example.demo.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@EqualsAndHashCode(of="seq")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LEAGUE")
public class LeagueEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "NAME" , unique = true , nullable = false)
    private String name;




}
