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
    private Player playerId;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;
}
