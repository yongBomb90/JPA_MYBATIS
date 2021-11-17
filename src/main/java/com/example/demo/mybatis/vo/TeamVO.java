package com.example.demo.mybatis.vo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@ToString
public class TeamVO {

    private Long seq;

    private String name; // 로그인 아이디

    private List<MemberVO> members;

}
