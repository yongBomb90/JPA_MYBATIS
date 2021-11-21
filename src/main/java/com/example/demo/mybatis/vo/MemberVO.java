package com.example.demo.mybatis.vo;

import com.example.demo.jpa.entity.MemberEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberVO {

    private Long seq;

    private String name;

    private String sex;

    private TeamVO team;


}
