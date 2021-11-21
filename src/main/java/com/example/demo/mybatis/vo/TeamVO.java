package com.example.demo.mybatis.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class TeamVO {

    private Long seq;

    private String name; // 로그인 아이디

    private List<MemberVO> members;

}


    //
//    private LeaugueVO league;


