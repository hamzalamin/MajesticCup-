package com.wora.majesticcup.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "teams", collation = "{ 'locale': 'simple' }")
public class Team {
    @Id
    private String id;
    private String name;

    public Team(String name) {
        this.name = name;
    }
}
