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
public class Statistic {
    @Id
    private String id;
    private Player playerId;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;
    private Result result;
}
