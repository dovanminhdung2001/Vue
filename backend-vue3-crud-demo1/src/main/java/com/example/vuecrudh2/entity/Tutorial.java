package com.example.vuecrudh2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Tutorial {
    @Id
    private String id;
    private String title;
    private String description;
    private Boolean published;
}
