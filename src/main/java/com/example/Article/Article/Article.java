package com.example.Article.Article;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime createDate;

}
