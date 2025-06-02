package com.library.libraryappapplication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String firstName; // ім’я автора
    private String lastName;  // прізвище автора

    @Column(name = "publish_year")
    private int publishYear;

    private int quantity;
}

