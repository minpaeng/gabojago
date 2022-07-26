package com.hanium.gabojago.repository;

import com.hanium.gabojago.domain.Bookmark;
import com.hanium.gabojago.domain.Spot;
import com.hanium.gabojago.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
     Long countBySpot(Spot spot);

     Optional<Bookmark> findBySpotAndUser(Spot spot, User user);

     List<Bookmark> findByUser(User user);

     Long countByUser(User user);
}
