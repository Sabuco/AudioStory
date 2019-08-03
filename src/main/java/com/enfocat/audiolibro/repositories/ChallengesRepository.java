package com.enfocat.audiolibro.repositories;

import com.enfocat.audiolibro.models.Challenges;
import com.enfocat.audiolibro.models.Chapter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChallengesRepository extends CrudRepository<Challenges, Long> {
   
}