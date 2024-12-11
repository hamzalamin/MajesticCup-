package com.wora.majesticcup.models.entities.embeddedDocuments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatchDetail {
    @Id
    private String id;
    private String matchId;
    private String team1;
    private String team2;
    private Result result;
    private String winner;
}
