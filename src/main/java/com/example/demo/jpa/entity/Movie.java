package com.example.demo.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
@Data
public class Movie extends Item {
    @Column(name = "GENRE")
    private String Genre;
}
