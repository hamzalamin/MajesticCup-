package com.wora.majesticcup.models.entities;

import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String city;
    private List<Player> players;
}
