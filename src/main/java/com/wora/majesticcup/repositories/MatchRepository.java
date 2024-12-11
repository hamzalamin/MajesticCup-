package com.wora.majesticcup.repositories;

import com.wora.majesticcup.models.entities.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {
}
