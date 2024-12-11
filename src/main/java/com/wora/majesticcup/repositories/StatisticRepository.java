package com.wora.majesticcup.repositories;

import com.wora.majesticcup.models.entities.embeddedDocuments.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {
}
