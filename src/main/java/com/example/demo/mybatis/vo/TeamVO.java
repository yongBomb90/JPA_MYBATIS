package com.example.demo.mybatis.vo;

import lombok.Builder;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TeamVO {

    private Long seq;

    private String name;

    private List<MemberVO> members; // 1:다 관계

}


    //
//    private LeaugueVO league;


