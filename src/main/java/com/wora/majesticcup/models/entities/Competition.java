package com.wora.majesticcup.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "competitions", collation = "{ 'locale': 'simple' }")
public class Competition {
    @Id
    private String id;
    private String name;
    private int numberOfTeams;
    private int currentRound;
    private List<String> rounds;
}
