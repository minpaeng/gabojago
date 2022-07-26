package com.hanium.gabojago.dto;

import com.hanium.gabojago.domain.Spot;
import com.hanium.gabojago.domain.SpotTag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class SpotResponse {
    private Long spotId;
    private String spotName;
    private String address;
    private String region;
    private String detail;
    private String tel;
    private String spotImage;
    private Integer viewCnt;
    private List<SpotTagResponse> spotTags;

    public SpotResponse(Spot entity) {
        this.spotId = entity.getSpotId();
        this.spotName = entity.getSpotName();
        this.address = entity.getAddress();
        this.region = entity.getRegion();
        this.detail = entity.getDetail();
        this.tel = entity.getTel();
        this.spotImage = entity.getSpotImage();
        this.viewCnt = entity.getViewCnt();
        this.spotTags = entity.getSpotTags().stream()
                .map(SpotTagResponse::new).collect(Collectors.toList());
    }

    public SpotResponse(SpotTag entity) {
        Spot spot = entity.getSpot();
        this.spotId = spot.getSpotId();
        this.spotName = spot.getSpotName();
        this.address = spot.getAddress();
        this.region = spot.getRegion();
        this.detail = spot.getDetail();
        this.tel = spot.getTel();
        this.spotImage = spot.getSpotImage();
        this.viewCnt = spot.getViewCnt();
        this.spotTags = spot.getSpotTags().stream()
                .map(SpotTagResponse::new).collect(Collectors.toList());
    }
}
