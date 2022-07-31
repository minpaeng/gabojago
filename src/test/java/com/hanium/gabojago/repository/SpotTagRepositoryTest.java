package com.hanium.gabojago.repository;

import com.hanium.gabojago.domain.SpotTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace. NONE)
@DataJpaTest
class SpotTagRepositoryTest {
    @Autowired SpotTagRepository spotTagRepository;

    @Test
    @DisplayName("N+1 문제 발생 테스트")
    void testSpotTagRepository() {
        List<SpotTag> spotTags = spotTagRepository.findTop5By();

        for (SpotTag spotTag : spotTags) {
            System.out.println("---- spotTag.spot 조회: " + spotTag.getSpot().getSpotName());

        }
    }
}