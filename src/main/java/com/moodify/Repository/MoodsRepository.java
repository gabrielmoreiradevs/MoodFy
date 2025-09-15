package com.moodify.Repository;

import com.moodify.Model.Moods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodsRepository extends JpaRepository<Moods, Long> {
}
