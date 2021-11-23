package com.example.demo.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@EqualsAndHashCode(of="seq")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LEAGUE")
@NamedEntityGraph(name = "LeagueEntity.teams", attributeNodes = { @NamedAttributeNode("teams")})
public class LeagueEntity {
    @OneToMany(mappedBy="league" , fetch = FetchType.LAZY )
    private List<TeamEntity> teams;

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "NAME" , unique = true , nullable = false)
    private String name;


}
