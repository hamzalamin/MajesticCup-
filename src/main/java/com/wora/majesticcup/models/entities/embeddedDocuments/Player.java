package com.wora.majesticcup.models.entities.embeddedDocuments;

import lombok.*;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    private String id;
    private String name;
    private String surname;
    private String position;
    private Integer number;
}