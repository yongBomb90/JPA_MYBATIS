package com.example.demo.jpa.projection;


public interface LeugueProjection {
    String getName();
    Long getSeq();
    default String getNickName() {
        return getSeq() + "번 " + getName();
    }
}



