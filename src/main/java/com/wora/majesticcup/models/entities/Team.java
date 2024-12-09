package com.wora.majesticcup.models.entities;

import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "teams", collation = "{ 'locale': 'simple' }")
public class Team {
    @Id
    private String id;
    @NotBlank
    private String name;
    private String city;
    private List<Player> players;
}
