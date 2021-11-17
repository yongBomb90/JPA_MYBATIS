package com.example.demo.mybatis.vo;

import com.example.demo.jpa.entity.MemberEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
public class MemberVO {

    private Long seq;

    private String name;

    private LocalDateTime birthDay;

    private String sex;


}
