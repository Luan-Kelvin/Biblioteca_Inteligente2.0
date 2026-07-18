package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors", schema = "smartlibrary")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    private LocalDate dateOfBirth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "livro_and_author",
            joinColumns = @JoinColumn(name = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private List<Book> books = new ArrayList<>();

    public Author(String name, String country, LocalDate dateOfBirth) {
        this.name = name;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    public void addBook(Book book){
        if (book == null){
            return;
        }

        if (books.add(book)){
            book.getAuthors().add(this);
        }
    }
}
