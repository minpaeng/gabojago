package com.hanium.gabojago.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long spotId;

    @Column
    String spotName;

    @Column
    String address;

    @Column
    String region;

    @Column
    String detail;

    @Column
    String tel;

    @Column
    String spotImage;

    @Column
    Integer viewCnt;

    @OneToMany(mappedBy = "spot")
    List<SpotTag> spotTags = new ArrayList<>();

}