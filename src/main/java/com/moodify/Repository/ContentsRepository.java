package com.moodify.Repository;

import com.moodify.Model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {

    List<Contents> findContentsByMoods_Id(Long moodId);
}
