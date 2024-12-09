package com.wora.majesticcup.models.entities.embeddedDocuments;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;
}
