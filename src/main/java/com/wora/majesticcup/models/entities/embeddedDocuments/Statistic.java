package com.wora.majesticcup.models.entities.embeddedDocuments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Statistic {
    private String playerId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
}
