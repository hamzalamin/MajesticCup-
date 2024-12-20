package com.wora.majesticcup.models.entities.embeddedDocuments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {
    private Integer team1Goals;
    private Integer team2Goals;
    private List<Statistic> statistics;
}
