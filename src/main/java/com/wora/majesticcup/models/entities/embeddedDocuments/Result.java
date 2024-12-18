package com.wora.majesticcup.models.entities.embeddedDocuments;

import com.wora.majesticcup.models.entities.Match;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
