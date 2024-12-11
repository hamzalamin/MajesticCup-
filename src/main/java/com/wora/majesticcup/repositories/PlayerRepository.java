package com.wora.majesticcup.repositories;

import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
}
