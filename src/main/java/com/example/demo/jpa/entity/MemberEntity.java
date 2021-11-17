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
@Table(name = "MEMBER")
public class MemberEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "NAME" , unique = true , nullable = false)
    private String name;  

    @Column(name = "BIRTH_DAY" )
    private LocalDateTime birthDay;  

    @Column(name = "SEX"  , columnDefinition = "ENUM('X','M','F') DEFAULT 'X' " )
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne(targetEntity = TeamEntity.class)
    @JoinColumn(name = "seq")
    private TeamEntity team;

    public enum Sex {
        X, // 모름
        M, // 남자
        F  // 여자
        ;
    }

}
