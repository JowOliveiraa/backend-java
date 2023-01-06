package com.meuprojeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "tb_book")
@NoArgsConstructor
public class Book implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 50)
    private String publisher;
    private Integer publishingDate;
    @Column(nullable = false, length = 100)
    private String author;
}
