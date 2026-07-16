package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "books", schema = "smartlibrary")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    private String descricao;

    private LocalDate dataPublicacao;

    @Column(nullable = false)
    private Double preco;

    private Integer estoque = 0;

    public Book(String title, String isbn, String descricao, LocalDate dataPublicacao, Double preco, Integer estoque) {
        this.title = title;
        this.isbn = isbn;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.preco = preco;
        this.estoque = estoque;
    }
}
