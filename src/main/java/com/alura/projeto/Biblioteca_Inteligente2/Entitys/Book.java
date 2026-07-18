package com.alura.projeto.Biblioteca_Inteligente2.Entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.EditorKit;
import java.time.LocalDate;
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

    @Column(nullable = false, unique = true)
    private String isbn;

    private String descricao;

    private LocalDate dataPublicacao;

    @Column(nullable = false)
    private Double preco;

    private Integer estoque = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_and_category",
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

    public Book(String title, String isbn, String descricao, LocalDate dataPublicacao, Publisher publisher, Double preco, Integer estoque) {
        this.title = title;
        this.isbn = isbn;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.preco = preco;
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
