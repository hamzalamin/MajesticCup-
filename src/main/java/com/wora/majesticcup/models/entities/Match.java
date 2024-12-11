package com.wora.majesticcup.models.entities;

import com.wora.majesticcup.models.entities.embeddedDocuments.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "matches", collation = "{ 'locale': 'simple' }")
public class Match {
    @Id
    private String id;
    private Integer round;
    private String team1;
    private String team2;
    private Result result;
}
