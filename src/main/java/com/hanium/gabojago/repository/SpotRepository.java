package com.hanium.gabojago.repository;

import com.hanium.gabojago.domain.Spot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findTop10ByOrderByViewCntDesc();

    Page<Spot> findByRegion(String region, Pageable pageable);

    List<Spot> findAllBySpotId(Long spotId);

}