package ru.coursework.Planetarium.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDTO {
    private long id;
    private String title;
    private String description;
}
