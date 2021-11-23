package com.example.demo.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
@Data
public class Car extends Item {
    @Column(name = "BRAND")
    private String brand;
}
