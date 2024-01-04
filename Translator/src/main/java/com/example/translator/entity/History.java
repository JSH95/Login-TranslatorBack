package com.example.translator.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.*;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String id;

    @Column(name = "search_word", length = 200)
    private String searchWord;

    @Column(name = "search_lang", length = 2)
    private String searchLang;


    @Column(name = "search_date")
    @CreationTimestamp
    private LocalDate searchDate;
}
