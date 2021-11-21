package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

    MemberVO selectMember(MemberVO param);

    MemberVO selectMember2(MemberVO param);



}
