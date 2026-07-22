package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", schema = "smartlibrary")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String title;

    private String descricao;

    private Integer yearOfPublication;

    private Double price;

    private Integer estoque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_and_category",
            schema = "smartlibrary",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Loan> loans = new ArrayList<>();

    @ManyToMany(mappedBy = "favoritos")
    List<User> userWhoFavorited = new ArrayList<>();

    @Builder
    public Book(String title, String descricao, Integer yearOfPublication, Publisher publisher, Double price, Integer estoque) {
        this.title = title;
        this.descricao = descricao;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.estoque = estoque;

        associatePublisher(publisher);
    }

    public void addCategoriy(Category category){
        if(!categories.contains(category)){
            categories.add(category);
        }

        if (!category.getBooks().contains(this)){
            category.getBooks().add(this);
        }
    }

    public void addAuthor(Author author){
        if (author == null){
            return;
        }

        if (!authors.contains(author)){
            authors.add(author);
        }

        if (!author.getBooks().contains(this)){
            author.addBook(this);
        }
    }

    public void addLoan(Loan loan){
        if(!loans.contains(loan)){
            loans.add(loan);
        }
    }

    public void associatePublisher(Publisher publisher){
        if (publisher == null){
            return;
        }

        this.publisher = publisher;

        if (!publisher.getBooks().contains(this)){
            publisher.addBook(this);
        }
    }

}
