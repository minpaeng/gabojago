package com.hanium.gabojago.repository;

import com.hanium.gabojago.domain.SpotTag;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotTagRepository extends JpaRepository<SpotTag, Long> {
    @EntityGraph(value = "SpotTagWithSpot")
    List<SpotTag> findTop5By();
}
