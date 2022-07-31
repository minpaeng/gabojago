package com.hanium.gabojago.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@NamedEntityGraph(name = "SpotTagWithSpot", attributeNodes = @NamedAttributeNode("spot"))
public class SpotTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long spotTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spot_id")
    Spot spot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    Tag tag;

}
