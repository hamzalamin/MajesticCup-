package com.wora.majesticcup.repositories;

import com.wora.majesticcup.models.entities.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepository extends MongoRepository<Round, String> {
}
