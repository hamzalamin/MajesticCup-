package com.wora.majesticcup.repositories;

import com.wora.majesticcup.models.entities.embeddedDocuments.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {
}
