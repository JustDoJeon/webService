package com.webservice.study.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class posts
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length =500, nullable = false)
    private String content;


    private String author;

    @Builder
    public posts(String title, String Content , String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
