package com.wora.majesticcup.models.entities;

import com.wora.majesticcup.models.entities.embeddedDocuments.MatchDetail;
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
@Document(collection = "rounds")
public class Round {
    @Id
    private String id;
    private int roundNumber;
    private String competitionId;
    private List<MatchDetail> matches;
}
